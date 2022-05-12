package com.sda.raoul.petclinic.repository.base;

import com.sda.raoul.petclinic.utils.SessionManager;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Optional;

public class BaseRepositoryImpl<T, ID> implements BaseRepository<T, ID> {
    private final Class<T> clazz;

    public BaseRepositoryImpl(Class<T> clazz) {
        this.clazz = clazz;
    }


    @Override
    public Optional<T> findById(ID employeeNumber) {
        try {
            Session session = SessionManager.getSessionFactory().openSession();

            T employee = session.find(clazz, employeeNumber);

            session.close();
            return Optional.ofNullable(employee);
        } catch (Exception ex) {
            ex.printStackTrace();
            return Optional.empty();
        }
    }

    @Override
    public void create(T entity) {
        Transaction transaction = null;
        try {
            Session session = SessionManager.getSessionFactory().openSession();
            transaction = session.beginTransaction();

            session.save(entity);

            transaction.commit();
            session.close();

        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
        } // facem finally daca vrem sa fim complet siguri ca inchidem sesiunea in toate cazurile, finally se
        // se executa in orice conditie

    }

    @Override
    public void update(T entity) {
        Transaction transaction = null;
        try {
            Session session = SessionManager.getSessionFactory().openSession();
            transaction = session.beginTransaction();

            session.update(entity);

            transaction.commit();
            session.close();

        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
        }
    }

    @Override
    public void delete(T entity) {
        Transaction transaction = null;
        try {
            Session session = SessionManager.getSessionFactory().openSession();
            transaction = session.beginTransaction();

            session.delete(entity);

            transaction.commit();
            session.close();

        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
        }
    }

    @Override
    public void deleteById(ID id) {
        Transaction transaction = null;
        try {
            Session session = SessionManager.getSessionFactory().openSession();
            transaction = session.beginTransaction();

            // prima data il citim
            T entity = session.find(clazz, id);
            if (entity != null) {
                session.delete(entity);
            }

            transaction.commit();
            session.close();

        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
        }
    }

    @Override
    public List<T> findAll() {
        try {
            Session session = SessionManager.getSessionFactory().openSession();

            List<T> entities = session.createQuery("from " + clazz.getName(), clazz).list();

            session.close();
            return entities;
        } catch (Exception ex) {
            ex.printStackTrace();
            return List.of(); /*new ArrayList()*/
        }

    }
}