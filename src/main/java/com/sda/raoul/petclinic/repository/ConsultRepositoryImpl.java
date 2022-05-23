package com.sda.raoul.petclinic.repository;

import com.sda.raoul.petclinic.model.Consult;
import com.sda.raoul.petclinic.repository.base.BaseRepositoryImpl;
import com.sda.raoul.petclinic.service.exception.InvalidParameterException;
import com.sda.raoul.petclinic.utils.SessionManager;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

public class ConsultRepositoryImpl extends BaseRepositoryImpl<Consult, Long> implements ConsultRepository {
    public ConsultRepositoryImpl() {
        super(Consult.class);
    }

    @Override
    public List<Consult> findAllWithUnvaccinatedPets() {
        try {
            Session session = SessionManager.getSessionFactory().openSession();
            List<Consult> consults = session.createQuery("FROM Consult c WHERE c.pet.isVaccinated=false ", Consult.class).list();

            session.close();
            return consults;
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}
