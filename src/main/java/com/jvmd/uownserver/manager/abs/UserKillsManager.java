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
        User user = datastore.createQuery(User.class)
                .filter(Filters.eq("username", username))
                .stream()
                .findFirst()
                .orElse(null);

        if (user == null) {
            user = new User(username, EOwn.GREEN, 0);
            addObject(user);
        }

        user.setKills(user.getKills() + 1);
        addObject(user);
    }

    public int getKills(String username) {
        return datastore.createQuery(User.class)
                .filter(Filters.eq("username", username))
                .stream().findFirst()
                .map(User::getKills)
                .orElse(0);
    }

    private void removeKill(String username) {
        User user = datastore.createQuery(User.class).filter(Filters.eq("username", username)).stream().findFirst().orElse(null);

        if (user == null) return;

        if (user.getKills() > 0) {
            user.setKills(user.getKills() - 1);
            addObject(user);
        }
    }


}
