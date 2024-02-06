package org.example.crud.services;

import org.example.db.HibernateUtil;
import org.example.entities.Ticket;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class TicketCrudService {
    private Session session = HibernateUtil.getInstance().getSessionFactory().openSession();
    public Ticket create(Ticket ticket) {

        Transaction transaction = session.beginTransaction();

        if (ticket.getClient() == null || ticket.getFromPlanetId() == null || ticket.getToPlanetId() == null) {
            throw new IllegalArgumentException("Не можна зберегти квиток для неіснуючого або null клієнта/планети");
        }

        try {
            session.persist(ticket);
            transaction.commit();

            return ticket;

        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }

        return ticket;
    }


    public Ticket update(Ticket ticket) {

        if (ticket == null || ticket.getId() == 0 || ticket.getCreatedAt() == null ||
                ticket.getClient() == null || ticket.getFromPlanetId() == null || ticket.getToPlanetId() == null){
            throw new IllegalArgumentException("Invalid ticket : " + ticket);
        }

        Transaction transaction = session.beginTransaction();

        try{
            session.merge(ticket);
            transaction.commit();

            return ticket;

        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }


        return ticket;
    }


    public Ticket getById(int clientId) {
        return session.get(Ticket.class, clientId);

    }



    public List<Ticket> getAll() {
        return session.createQuery("from client", Ticket.class).list();

    }


    public void deleteById(int clientId) {
        Transaction transaction = session.beginTransaction();
        Ticket ticket = session.get(Ticket.class,clientId);
        session.remove(ticket);
        transaction.commit();

    }
}
