package com.sda.raoul.petclinic.repository;

import com.sda.raoul.petclinic.model.Client;
import com.sda.raoul.petclinic.repository.base.BaseRepositoryImpl;
import com.sda.raoul.petclinic.utils.SessionManager;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Optional;

public class ClientRepositoryImpl extends BaseRepositoryImpl<Client, Long> implements ClientRepository {
    public ClientRepositoryImpl() {
        super(Client.class);
    }

    @Override
    public Optional<Client> findByFirstNameAndLastName(String firstName, String lastName) {
        try {
            Session session = SessionManager.getSessionFactory().openSession();
            Query<Client> query = session.createQuery("FROM Client c WHERE c.firstName=:firstName AND c.lastName=:lastName", Client.class);
            query.setParameter("firstName", firstName);
            query.setParameter("lastName", lastName);
            List<Client> clients = query.list();

            session.close();
//            return clients.stream().findAny();
            if (clients.isEmpty()) {
                return Optional.empty();
            } else {
                return Optional.of(clients.get(0));
            }
        } catch (Exception e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }
}
