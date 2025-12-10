package com.jvmd.uownserver.manager.abs;

import com.jvmd.uownserver.manager.Managers;
import com.jvmd.uownserver.model.EOwn;
import com.jvmd.uownserver.model.User;
import com.jvmd.uownserver.util.ConfigUtil;
import com.jvmd.uownserver.util.MorphiaUtil;
import dev.morphia.Datastore;
import dev.morphia.query.filters.Filters;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class UserOwnManager extends ObjectManagerImpl<User> {

    private final Datastore datastore = MorphiaUtil.getDatastore();

    public UserOwnManager() {
        ConfigUtil.getScheduler().scheduleSyncRepeatingTask(ConfigUtil.getP(), ()->{
            datastore.find(User.class).forEach((user) -> {
                int kills = Managers.getUserKillsManager().getKills(user.getUsername());
                user.setKills(kills);
                user.calcOwn();
                setUserOwn(user);
            });
        }, 1L , 60L);
    }

    public EOwn getUserOwn(String username) {
        User user = datastore.createQuery(User.class).filter(Filters.eq("username", username)).stream().findFirst().get();
        return user.getOwn();
    }

    private void setUserOwn(User user) {
        datastore.save(user);
    }

}
