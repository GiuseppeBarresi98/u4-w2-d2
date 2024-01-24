package org.example.Class;


import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "eventi")
public class Evento {
    @Id
    @GeneratedValue
    private Long Id;

    private String titolo;
    private LocalDate dataEvento;

    @Enumerated(EnumType.STRING)
    private tipoEvento tipoEvento;

    private int numeroMassimoPartecipanti;

    @OneToMany(mappedBy = "evento")
    private List<Partecipazioni> partecipazioni;

   @OneToOne
    @JoinColumn(name = "location_id")
    private Location location;

    public Evento(String titolo, LocalDate dataEvento, tipoEvento tipoEvento, int numeroMassimoPartecipanti){
        this.titolo = titolo;
        this.dataEvento = dataEvento;
        this.tipoEvento = tipoEvento;
        this.numeroMassimoPartecipanti = numeroMassimoPartecipanti;
    };

    public Evento() {

    }



    public String getTitolo() {
        return titolo;
    }

    public Long getId() {
        return Id;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public int getNumeroMassimoPartecipanti() {
        return numeroMassimoPartecipanti;
    }

    public void setNumeroMassimoPartecipanti(int numeroMassimoPartecipanti) {
        this.numeroMassimoPartecipanti = numeroMassimoPartecipanti;
    }

    public void setDataEvento(LocalDate dataEvento) {
        this.dataEvento = dataEvento;
    }

    public LocalDate getDataEvento() {
        return dataEvento;
    }


}
