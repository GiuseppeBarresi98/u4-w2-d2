package org.example.Class;

import javax.persistence.Entity;
import java.time.LocalDate;


@Entity
public class partitaDiCalcio extends Evento {
  private String squadraDiCasa;
  private String squadraOspite;

  private String squadraVincente;

  private int numeroGolCasa;
  private int numeroGolTraferta;

    public partitaDiCalcio(String titolo, LocalDate dataEvento, org.example.Class.tipoEvento tipoEvento, int numeroMassimoPartecipanti, Location location, String squadraDiCasa,String squadraOspite) {
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
}
