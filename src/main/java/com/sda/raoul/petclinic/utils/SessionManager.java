package com.sda.raoul.petclinic.utils;

import com.sda.raoul.petclinic.model.Client;
import com.sda.raoul.petclinic.model.Consult;
import com.sda.raoul.petclinic.model.Pet;
import com.sda.raoul.petclinic.model.Veterinarian;
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
        configuration.addAnnotatedClass(Veterinarian.class);
        configuration.addAnnotatedClass(Client.class);
        configuration.addAnnotatedClass(Consult.class);
        configuration.addAnnotatedClass(Pet.class);
    }
}
