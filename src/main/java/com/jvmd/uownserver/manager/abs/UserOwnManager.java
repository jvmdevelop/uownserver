package com.jvmd.uownserver.manager.abs;

import com.jvmd.uownserver.model.EOwn;
import com.jvmd.uownserver.model.User;

import java.util.HashMap;

public class UserOwnManager extends ObjectManagerImpl<User> {


    private HashMap<String, EOwn> usersOwns = new HashMap<>();

    public UserOwnManager() {
        while(true) getObjects().forEach((object -> {
            EOwn own = ((User) object).getOwn();
            String username = ((User) object).getUsername();
            usersOwns.put(username, own);
        }));
    }

    public EOwn getUserOwn(String username) {
        return usersOwns.get(username);
    }


}
