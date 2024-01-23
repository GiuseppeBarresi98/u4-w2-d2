package org.example.Class;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class EventoDAO {

    private final EntityManager em;

    public EventoDAO(EntityManager em){
        this.em = em;
    }

    public  void saveEvent(Evento evento){
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(evento);
        transaction.commit();
        System.out.println("Successo");
    }

    public Evento getById(long Id){
        return em.find(Evento.class,Id);
    };

    public void deleteEventbyId(long Id){
      Evento eventoDaEliminare = em.find(Evento.class,Id);

      if(eventoDaEliminare != null){
          EntityTransaction transaction = em.getTransaction();
          transaction.begin();
          em.remove(eventoDaEliminare);
          transaction.commit();
          System.out.println("Eliminato con successo");


      }
      else {
          System.out.println("Elemento con id:" + Id + "non è stato trovato");
      }

    };


}
