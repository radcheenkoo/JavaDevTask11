package org.example.entities;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "ticket")
public class Ticket {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;
    @JoinColumn(name = "created_at")
    private Timestamp createdAt;
    @ManyToOne
    @JoinColumn(name = "client")
    private Client client;

    @ManyToOne
    @JoinColumn(name = "from_planet_id")
    private Planet fromPlanetId;

    @ManyToOne
    @JoinColumn(name = "to_planet_id")
    private Planet toPlanetId;


    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public int getId() {
        return id;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }


    public Planet getFromPlanetId() {
        return fromPlanetId;
    }

    public void setFromPlanetId(Planet fromPlanetId) {
        this.fromPlanetId = fromPlanetId;
    }

    public Planet getToPlanetId() {
        return toPlanetId;
    }

    public void setToPlanetId(Planet toPlanetId) {
        this.toPlanetId = toPlanetId;
    }
}
