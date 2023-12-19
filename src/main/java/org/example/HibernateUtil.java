package org.example;

import org.example.entities.Client;
import org.example.entities.Planet;
import org.example.entities.Ticket;
import org.flywaydb.core.Flyway;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static final HibernateUtil INSTANCE;

    private SessionFactory sessionFactory;

    static {
        INSTANCE = new HibernateUtil();
    }

    private HibernateUtil(){

        this.sessionFactory = new Configuration()
                .addAnnotatedClass(Client.class)
                .addAnnotatedClass(Planet.class)
                .addAnnotatedClass(Ticket.class)
                .buildSessionFactory();

    }

    public static HibernateUtil getInstance(){
        return INSTANCE;
    }
    public SessionFactory getSessionFactory(){
        return  this.sessionFactory;
    }
    public void closeSessionFactory(){
        this.sessionFactory.close();
    }

}
