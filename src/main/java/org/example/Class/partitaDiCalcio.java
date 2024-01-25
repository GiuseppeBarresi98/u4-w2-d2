package org.example.Class;

import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import java.time.LocalDate;


@Entity
@NamedQuery(name = "get_partite_vinte_incasa", query = "SELECT p FROM partitaDiCalcio p WHERE p.numeroGolCasa > p.numeroGolTraferta")
@NamedQuery(name = "get_partite_vinte_intrasferta",query = "SELECT p FROM partitaDiCalcio p WHERE p.numeroGolCasa < p.numeroGolTraferta")
public class partitaDiCalcio extends Evento {
  private String squadraDiCasa;
  private String squadraOspite;

  private String squadraVincente;

  private int numeroGolCasa;
  private int numeroGolTraferta;

    public partitaDiCalcio(String titolo, LocalDate dataEvento, tipoEvento tipoEvento, int numeroMassimoPartecipanti, Location location, String squadraDiCasa,String squadraOspite) {
        super(titolo, dataEvento, tipoEvento, numeroMassimoPartecipanti, location);
        this.squadraDiCasa = squadraDiCasa;
        this.squadraOspite = squadraOspite;
    }
    public partitaDiCalcio(){

    }

    public String getSquadraDiCasa() {
        return squadraDiCasa;
    }

    public void setSquadraDiCasa(String squadraDiCasa) {
        this.squadraDiCasa = squadraDiCasa;
    }

    public void setNumeroGolCasa(int numeroGolCasa) {
        this.numeroGolCasa = numeroGolCasa;
    }

    public void setNumeroGolTraferta(int numeroGolTraferta) {
        this.numeroGolTraferta = numeroGolTraferta;
    }
}
