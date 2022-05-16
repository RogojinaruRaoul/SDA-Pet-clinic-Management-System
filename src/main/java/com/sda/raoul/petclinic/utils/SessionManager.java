package com.sda.raoul.petclinic.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

//singleton
public class SessionManager extends AbstractSessionManager {

    private static final SessionManager INSTANCE = new SessionManager();

    private SessionManager() {
    }

    public static SessionFactory getSessionFactory() {
        return INSTANCE.getSessionFactory("pet_clinic");
    }

    public static void shutDown() {
        INSTANCE.shutdownSessionManager();
    }

    @Override
    protected void setAnnotatedClasses(Configuration configuration) {
//       add model classes here
    }
}
