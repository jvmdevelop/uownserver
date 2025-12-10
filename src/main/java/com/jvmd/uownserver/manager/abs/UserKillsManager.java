package com.jvmd.uownserver.manager.abs;

import com.jvmd.uownserver.model.EOwn;
import com.jvmd.uownserver.model.User;
import com.jvmd.uownserver.util.MorphiaUtil;
import dev.morphia.Datastore;
import dev.morphia.query.Query;
import dev.morphia.query.filters.Filter;
import dev.morphia.query.filters.Filters;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class UserKillsManager extends ObjectManagerImpl<User> {

    private final Datastore datastore = MorphiaUtil.getDatastore();

    private final class DelayCountDowner implements Runnable {
        @Override
        public void run() {
            Query<User> users = datastore.find(User.class);
            users.stream().forEach(user -> {
                int kills = user.getKills();
                if (kills > 0) {
                    removeKill(user.getUsername());
                }
            });

        }
    }

    private final ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();

    public UserKillsManager() {
        executor.scheduleAtFixedRate(new DelayCountDowner(), 1, 2, TimeUnit.SECONDS);
    }

    public void addKill(String username) {
        User user = datastore.createQuery(User.class).filter(Filters.eq("username", username)).stream().findFirst().get();
        if (user == null) {
            datastore.save(new User(username, EOwn.GREEN, 0));
        }
        user.setKills(user.getKills() + 1);
        datastore.save(user);
    }

    public int getKills(String username) {
        return datastore.createQuery(User.class).filter(Filters.eq("username" , username)).iterator().next().getKills();
    }

    private void removeKill(String username) {
        User user = datastore.createQuery(User.class).filter(Filters.eq("username", username)).stream().findFirst().get();
        user.setKills(user.getKills() - 1);
        datastore.save(user);
    }


}
