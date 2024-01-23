package org.example;

import org.example.Class.Evento;
import org.example.Class.EventoDAO;
import org.example.Class.tipoEvento;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;

public class Application {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestioneeventi");

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();
        EventoDAO event = new EventoDAO(em);

        Evento evento1 = new Evento("Maneskin", LocalDate.of(2007, 12, 3), tipoEvento.PUBBLICO,500);
        Evento evento2 = new Evento("Tiziano Ferro", LocalDate.of(2007, 12, 3), tipoEvento.PUBBLICO,500);



        event.deleteEventbyId(1);
        event.deleteEventbyId(2);
        event.deleteEventbyId(3);



        Evento eventoById = event.getById(1);
        System.out.println(eventoById.getNumeroMassimoPartecipanti());

    }


}
