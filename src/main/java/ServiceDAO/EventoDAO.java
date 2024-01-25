package ServiceDAO;

import org.example.Class.Concerti;
import org.example.Class.Evento;
import org.example.Class.Genere;
import org.example.Class.partitaDiCalcio;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

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


    public List<Concerti> trovaPerGenere(Genere genere){
        TypedQuery<Concerti> getall = em.createQuery("SELECT c FROM Concerti c WHERE c.genere=:g", Concerti.class);
        getall.setParameter("g",genere);
        return getall.getResultList();
    };

    public List<Concerti> trovaPerStreaming(boolean streaming){
        TypedQuery<Concerti> getList = em.createQuery("SELECT c From Concerti c WHERE c.streaming=:g", Concerti.class);
        getList.setParameter("g",streaming);
        return getList.getResultList();

    };

    public List<partitaDiCalcio> getPartiteVinteInCasa(){
        return em.createNamedQuery("get_partite_vinte_incasa", partitaDiCalcio.class).getResultList();

    };

    public List<partitaDiCalcio> getPartiteVinteInTrasfera(){
        return em.createNamedQuery("get_partite_vinte_intrasferta", partitaDiCalcio.class).getResultList();
    };


}
