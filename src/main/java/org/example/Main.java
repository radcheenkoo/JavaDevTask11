package org.example;

import org.example.crud.services.ClientCrudService;
import org.example.crud.services.PlanetCrudService;
import org.example.crud.services.TicketCrudService;
import org.example.db.FlywayMigration;
import org.example.entities.Client;
import org.example.entities.Planet;
import org.example.entities.Ticket;

import java.sql.Timestamp;

public class Main {
    public static void main(String[] args) {
        FlywayMigration.migrating();

        ClientCrudService clientCrudService = new ClientCrudService();
        PlanetCrudService planetCrudService = new PlanetCrudService();
        TicketCrudService ticketCrudService = new TicketCrudService();

        Client dima = new Client();
        dima.setName("Dima");

        // зберігаю обєкт Client
        clientCrudService.create(dima);

        Planet mars = new Planet();
        mars.setId("MARS");
        mars.setName("Mars");

        Planet venus = new Planet();
        venus.setId("VENUS");
        venus.setName("Venus");

        //Зберігаю обєкти Planet
        planetCrudService.create(mars);
        planetCrudService.create(venus);

        Ticket ticketForDima = new Ticket();
        ticketForDima.setClient(dima);

        Timestamp timestamp = new Timestamp(System.currentTimeMillis() - 60*60*24*20);
        ticketForDima.setCreatedAt(timestamp);
        ticketForDima.setFromPlanetId(mars);
        ticketForDima.setToPlanetId(venus);

        ticketCrudService.create(ticketForDima);


    }
}