package org.example.Class;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.LocalDate;

@Entity

public class Concerti extends Evento {
   @Enumerated(EnumType.STRING)
    private Genere genere;
    private boolean streaming;

    public Concerti() {
    }

    public Concerti(String titolo, LocalDate dataEvento, org.example.Class.tipoEvento tipoEvento, int numeroMassimoPartecipanti, Location location, Genere genere,boolean streaming) {
        super(titolo, dataEvento, tipoEvento, numeroMassimoPartecipanti, location);
        this.genere = genere;
        this.streaming = streaming;
    }



}
