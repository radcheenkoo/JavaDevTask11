package org.example;

import org.example.crud.services.ClientCrudService;
import org.example.crud.services.PlanetCrudService;
import org.example.crud.services.TicketCrudService;
import org.example.entities.Client;
import org.example.entities.Planet;
import org.example.entities.Ticket;

import java.sql.Timestamp;

public class Main {
    public static void main(String[] args) {


        ClientCrudService clientCrudService = new ClientCrudService();
        PlanetCrudService planetCrudService = new PlanetCrudService();
        TicketCrudService ticketCrudService = new TicketCrudService();

        Client dima = new Client();
        dima.setName("Dima");

        clientCrudService.create(dima);

        Client bobFromDB = clientCrudService.getById(2);

        if (bobFromDB != null) {

            bobFromDB.setName("newBob");
            clientCrudService.update(bobFromDB);

        } else System.out.println("Client not found");


        Planet tatooine = new Planet();

        tatooine.setId("TATOOINE");
        tatooine.setName("Tatooine");

        planetCrudService.create(tatooine);


        Planet alderaan = planetCrudService.getById(tatooine.getId());
        if (alderaan != null) {
            alderaan.setName("Alderaan");

            planetCrudService.update(alderaan);
        }else System.out.println("Planet not found");

        Ticket ticketForDima = new Ticket();
        ticketForDima.setClient(dima);

        Timestamp timestamp = new Timestamp(System.currentTimeMillis() - 60 * 60 * 24 * 20);
        ticketForDima.setCreatedAt(timestamp);
        ticketForDima.setFromPlanetId(tatooine);
        ticketForDima.setToPlanetId(alderaan);

        ticketCrudService.create(ticketForDima);

        Ticket retrievedTicket = ticketCrudService.getById(ticketForDima.getId());

        Planet noth = new Planet();
        noth.setId("HOTH");
        noth.setName("noth");


        planetCrudService.create(noth);

        if (retrievedTicket != null) {
            Timestamp timestamp1 = new Timestamp(System.currentTimeMillis() - 60 * 60 * 12);

            retrievedTicket.setCreatedAt(timestamp1);
            retrievedTicket.setClient(bobFromDB);
            retrievedTicket.setFromPlanetId(tatooine);
            retrievedTicket.setToPlanetId(noth);

            ticketCrudService.update(retrievedTicket);
        } else System.out.println("Ticket not found");


    }
}