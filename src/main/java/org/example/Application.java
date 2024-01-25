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
        Evento ev1 = new Evento("Concerto", LocalDate.of(1998, 4, 23),tipoEvento.PUBBLICO,250,lo2);


        location.saveLocation(loc1);
        location.saveLocation(lo2);
        event.saveEvent(ev1);
        Persona ps1 = new Persona("Luca", "Fava", "fava@iammi.it", LocalDate.parse("1995-01-01"), Sesso.UOMO);
        Partecipazioni pa1 = new Partecipazioni(ps1, ev1, Stato.CONFERMATA);

        Location concertoloc = new Location("Roma","Lazio");
        location.saveLocation(concertoloc);
        Concerti concerto = new Concerti("Olimpico x Ferro", LocalDate.now(),tipoEvento.PUBBLICO,25000,concertoloc,Genere.CLASSICO,true);
        Concerti concerto2 = new Concerti("Queen Live at Wembley - In Streaming", LocalDate.now(), tipoEvento.PUBBLICO, 1, concertoloc, Genere.ROCK,true);
        Concerti concerto3 = new Concerti("Queen Live at Wembley - In Streaming", LocalDate.now(), tipoEvento.PUBBLICO, 1, concertoloc, Genere.ROCK,false);

        event.saveEvent(concerto2);
        event.saveEvent(concerto);
        event.saveEvent(concerto3);

        event.trovaPerGenere(Genere.ROCK).forEach(System.out::println);
        event.trovaPerStreaming(true).forEach(System.out::println);

        //persona.savePersona(ps1);
       // partecipazione.savePartecipazione(pa1);


        System.out.println(ev1.toString());
        System.out.println(ps1.toString());


        partitaDiCalcio partita1 = new partitaDiCalcio("Milan-Inter",LocalDate.now(),tipoEvento.PUBBLICO,50000,concertoloc,"Milan","Inter");
        partitaDiCalcio partita2 = new partitaDiCalcio("Juventus-Milan",LocalDate.now(),tipoEvento.PUBBLICO,60000,concertoloc,"Juventus","Milan");
       partitaDiCalcio partita3 = new partitaDiCalcio("Milan-Roma",LocalDate.now(),tipoEvento.PUBBLICO,50000,concertoloc,"Milan","Roma");
       partita3.setNumeroGolCasa(4);
       partita3.setNumeroGolTraferta(3);
        partita2.setNumeroGolTraferta(3);
        partita2.setNumeroGolCasa(1);
        partita1.setNumeroGolCasa(6);
        partita1.setNumeroGolTraferta(0);
        event.saveEvent(partita1);
        event.saveEvent(partita2);
        event.saveEvent(partita3);
        event.getPartiteVinteInCasa().forEach(System.out::println);
        event.getPartiteVinteInTrasfera().forEach(System.out::println );

    }
}
