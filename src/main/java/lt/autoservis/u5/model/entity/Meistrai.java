package lt.autoservis.u5.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;


import javax.persistence.*;
import java.util.Set;

@Entity
public class Meistrai {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String vardas_pavarde;


    @ManyToMany
    @JoinTable (
            name = "sujungimas_meistrai_specializacija",
            joinColumns = @JoinColumn(name = "meistrai_id"),
            inverseJoinColumns = @JoinColumn(name = "specializacija_id"))
    @JsonIgnore
    private Set<Specializacija> specializacijaMeistro;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "autoservisai_id")
    private Autoservisai autoservisoMeistrai;

    @ManyToOne
    @JoinColumn(name = "vertinimas_id")
    private Vertinimas meistroVertinimas;



    public Meistrai() {
    }

    public Meistrai(long id, String vardas_pavarde, long ivertinimas_id, Set<Specializacija> specializacijaMeistro, Autoservisai autoservisoMeistrai) {
        this.id = id;
        this.vardas_pavarde = vardas_pavarde;
        this.specializacijaMeistro = specializacijaMeistro;
        this.autoservisoMeistrai = autoservisoMeistrai;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getVardas_pavarde() {
        return vardas_pavarde;
    }

    public void setVardas_pavarde(String vardas_pavarde) {
        this.vardas_pavarde = vardas_pavarde;
    }


    public Set<Specializacija> getSpecializacijaMeistro() {
        return specializacijaMeistro;
    }

    public void setSpecializacijaMeistro(Set<Specializacija> specializacijaMeistro) {
        this.specializacijaMeistro = specializacijaMeistro;
    }

    public Autoservisai getAutoservisoMeistrai() {
        return autoservisoMeistrai;
    }

    public void setAutoservisoMeistrai(Autoservisai autoservisoMeistrai) {
        this.autoservisoMeistrai = autoservisoMeistrai;
    }

    @Override
    public String toString() {
        return "Meistrai{" +
                "id=" + id +
                ", vardas_pavarde='" + vardas_pavarde + '\'' +
                ", specializacijaMeistro=" + specializacijaMeistro +
                ", autoservisoMeistrai=" + autoservisoMeistrai +
                '}';
    }
}
