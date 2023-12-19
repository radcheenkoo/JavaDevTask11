package org.example.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import org.hibernate.boot.registry.selector.spi.StrategyCreator;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Entity
@Table(name = "client")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;

    @Column
    private String name;

    @OneToMany(mappedBy = "client")
    private List<Ticket> tickets = new ArrayList<>();

    public List<Ticket> getTickets() {
        return tickets;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}