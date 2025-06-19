package com.jvmd.uownserver.manager;

import com.jvmd.uownserver.manager.abs.UserOwnManager;
import lombok.Getter;


public final class Managers {

    @Getter
    private static final UserOwnManager userOwnManager;

    static {
        userOwnManager = new UserOwnManager();
    }

}

