package org.example.db;

import org.example.entities.Client;
import org.example.entities.Planet;
import org.example.entities.Ticket;
import org.flywaydb.core.Flyway;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static final HibernateUtil INSTANCE;

    private SessionFactory sessionFactory;

    private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String USER = "postgres";
    private static final String PASSWORD = "3272A567";

    static {
        INSTANCE = new HibernateUtil();
    }

    private HibernateUtil(){

        this.sessionFactory = new Configuration()
                .addAnnotatedClass(Client.class)
                .addAnnotatedClass(Planet.class)
                .addAnnotatedClass(Ticket.class)
                .buildSessionFactory();

        flywayMigration();
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
    private void flywayMigration(){
        Flyway.configure().dataSource(URL,USER,PASSWORD)
                .locations("classpath:db.migration")
                .baselineOnMigrate(true)
                .load().migrate();
    }

}
