package com.jvmd.uownserver.controller.impl;

import com.jvmd.uownserver.controller.Controller;
import com.jvmd.uownserver.manager.Managers;
import com.jvmd.uownserver.model.Donate;
import com.jvmd.uownserver.model.DonateType;
import com.jvmd.uownserver.model.EOwn;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UserOwnController implements Controller {

    public UserOwnController() {
        openConnection();
    }

    @Override
    public String getResponse(String path) {
        if (path.isEmpty()) return "String is empty";
        var ref = new Object() {
            int paramsCounter = 0;
        };
        path.chars().forEach(c -> {
            char ch = (char) c;
            if (ch == '?'){
                ref.paramsCounter += 1;
            }
        });
        if (ref.paramsCounter == 0) return "Params in empty";

        if (path.startsWith("/api/v1/user/own")){
            String userNameParam = path.substring("/api/v1/user/own?username=".length());
            EOwn o = Managers.getUserOwnManager().getUserOwn(userNameParam);
            return o.toString();
        }
        if (path.startsWith("/api/v1/donate/")) {
            String nickname = path.substring("/api/v1/donate?username=".length());
            String userDonate = path.substring("/api/v1/donate?username=".length() + nickname.length() + "?donate=".length());
            log.info("Received donation: {} {}", nickname,userDonate);
            Donate donate = new Donate();
            donate.setNickname(nickname);
            donate.setType(DonateType.valueOf(userDonate));
            Managers.getDonateManager().addObject(donate);
        }

        return null;
    }
}
