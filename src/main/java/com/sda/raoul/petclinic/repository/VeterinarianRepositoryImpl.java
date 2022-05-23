package com.sda.raoul.petclinic.repository;

import com.sda.raoul.petclinic.model.Veterinarian;
import com.sda.raoul.petclinic.repository.base.BaseRepositoryImpl;
import com.sda.raoul.petclinic.utils.SessionManager;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class VeterinarianRepositoryImpl extends BaseRepositoryImpl<Veterinarian, Long> implements VeterinarianRepository {
    public VeterinarianRepositoryImpl() {
        super(Veterinarian.class);
    }

    @Override
    public List<Veterinarian> findByMultipleParameters(String firstName, String lastName, String address, String speciality) {
        try {
            Session session = SessionManager.getSessionFactory().openSession();
            String query = "FROM Veterinarian v WHERE ";

            if (firstName != null && !firstName.isEmpty()) {
                query += " v.firstName=:firstName ";
            } else {
                query += "v.id is not null";
            }
            query += " And ";
            if (lastName != null && !lastName.isEmpty()) {
                query += " v.lastName=:lastName ";
            } else {
                query += "v.id is not null";
            }
            query += " And ";

            if (address != null && !address.isEmpty()) {
                query += " v.address=:address ";
            } else {
                query += "v.id is not null";
            }
            query += " And ";

            if (speciality != null && !speciality.isEmpty()) {
                query += " v.speciality=:speciality ";
            } else {
                query += "v.id is not null";
            }
            System.out.println(query);
            Query<Veterinarian> query1 = session.createQuery(query, Veterinarian.class);
            if (firstName != null && !firstName.isEmpty()) {
                query1.setParameter("firstName", firstName);
            }
            if (lastName != null && !lastName.isEmpty()) {
                query1.setParameter("lastName", lastName);
            }
            if (address != null && !address.isEmpty()) {
                query1.setParameter("address", address);
            }
            if (speciality != null && !speciality.isEmpty()) {
                query1.setParameter("speciality", speciality);
            }
            List<Veterinarian> veterinarians = query1.list();
            session.close();
            return veterinarians;
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}
