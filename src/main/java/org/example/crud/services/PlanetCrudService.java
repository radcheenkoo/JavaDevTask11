package org.example.crud.services;

import org.example.db.HibernateUtil;
import org.example.entities.Planet;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class PlanetCrudService {
    private Session session = HibernateUtil.getInstance().getSessionFactory().openSession();


    public boolean create(Planet planet) {

        Transaction transaction = session.beginTransaction();

        try {

            session.persist(planet);
            transaction.commit();

            return true;

        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }

        return false;
    }


    public boolean update(Planet planet) {

        if (planet == null){
            return false;
        }

        Transaction transaction = session.beginTransaction();

        try{
            session.merge(planet);
            transaction.commit();

            return true;

        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }


        return false;
    }


    public Planet getById(String planetId) {
        return session.get(Planet.class, planetId);

    }


    public List<Planet> getAll() {
        return session.createQuery("from planet", Planet.class).list();

    }


    public void deleteById(String planetId) {
        Transaction transaction = session.beginTransaction();
        Planet planet = session.get(Planet.class,planetId);
        session.remove(planet);
        transaction.commit();

    }
}
