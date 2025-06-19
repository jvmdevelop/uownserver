package com.jvmd.uownserver.util;

import lombok.Getter;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public final class SessionFactoryUtil {

    @Getter
    private static SessionFactory sessionFactory;

    static{
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }


}
