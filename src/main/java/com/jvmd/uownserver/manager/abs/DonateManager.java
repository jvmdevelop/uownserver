package com.jvmd.uownserver.manager.abs;

import com.jvmd.uownserver.model.Donate;
import dev.morphia.query.filters.Filters;

public class DonateManager extends ObjectManagerImpl<Donate> {


    public Donate findDonateByNickname(String nickname) {
        return datastore.createQuery(Donate.class)
                .filter(Filters.eq("nickname", nickname))
                .stream().findFirst().orElse(null);
    }


}
