package org.example;

import ServiceDAO.EventoDAO;
import ServiceDAO.LocationDao;
import ServiceDAO.PartecipazioniDAO;
import ServiceDAO.PersonaDAO;
import org.example.Class.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Application {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestioneeventi");

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();
        EventoDAO event = new EventoDAO(em);
        LocationDao location = new LocationDao(em);
        PartecipazioniDAO partecipazione = new PartecipazioniDAO(em);
        PersonaDAO persona = new PersonaDAO(em);

        Location loc1 = new Location("Grezzan", "Verona");
        Location lo2 = new Location("Roma","lazio");
        Evento ev1 = new Evento("giuseppe", LocalDate.of(1998, 4, 23),tipoEvento.PUBBLICO,250);

        List<Location> luoghi = new ArrayList<>();
        event.saveEvent(ev1);
        Persona ps1 = new Persona("Luca", "Fava", "fava@iammi.it", LocalDate.parse("1995-01-01"), Sesso.UOMO);
        Partecipazioni pa1 = new Partecipazioni(ps1, ev1, Stato.CONFERMATA);
        luoghi.add(lo2);
        luoghi.add(loc1);

        persona.savePersona(ps1);
        partecipazione.savePartecipazione(pa1);
        location.saveLocation(loc1);
    }
}
