package com.jvmd.uownserver.manager;

import com.jvmd.uownserver.manager.abs.UserKillsManager;
import com.jvmd.uownserver.manager.abs.UserOwnManager;
import lombok.Getter;


public final class Managers {

    @Getter
    private static final UserOwnManager userOwnManager;
    @Getter
    private static final UserKillsManager userKillsManager;

    static {
        userOwnManager = new UserOwnManager();
        userKillsManager = new UserKillsManager();
    }

}

