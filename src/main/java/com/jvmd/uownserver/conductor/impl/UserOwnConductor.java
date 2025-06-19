package com.jvmd.uownserver.conductor.impl;

import com.jvmd.uownserver.conductor.Conductor;
import com.jvmd.uownserver.manager.Managers;
import com.jvmd.uownserver.model.User;

public class UserOwnConductor implements Conductor<User> {
    @Override
    public void accept(User user) {
        Managers.getUserOwnManager().addObject(user);
    }
}
