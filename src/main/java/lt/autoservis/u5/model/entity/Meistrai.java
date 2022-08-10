package lt.autoservis.u5.model.entity;

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

    private Set<Specializacija> specializacijaMeistro;


    @ManyToOne
    @JoinColumn(name = "autoservisai_id")
    private Autoservisai meistroAutoservisas;

//    @ManyToOne
//    @JoinColumn(name = "meistroVertinimas")
//    private Vertinimas vertinimasMeistru;

    @OneToMany(mappedBy = "meistroVertinimas")
    Set<Vertinimas> meistroVertinimas;

    public Meistrai() {
    }

    public Meistrai(long id, String vardas_pavarde, Set<Specializacija> specializacijaMeistro, Autoservisai meistroAutoservisas, Set<Vertinimas> meistroVertinimas) {
        this.id = id;
        this.vardas_pavarde = vardas_pavarde;
        this.specializacijaMeistro = specializacijaMeistro;
        this.meistroAutoservisas = meistroAutoservisas;
        this.meistroVertinimas = meistroVertinimas;
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

    public Autoservisai getMeistroAutoservisas() {
        return meistroAutoservisas;
    }

    public void setMeistroAutoservisas(Autoservisai meistroAutoservisas) {
        this.meistroAutoservisas = meistroAutoservisas;
    }

    public Set<Vertinimas> getMeistroVertinimas() {
        return meistroVertinimas;
    }

    public void setMeistroVertinimas(Set<Vertinimas> meistroVertinimas) {
        this.meistroVertinimas = meistroVertinimas;
    }

    @Override
    public String toString() {
        return "Meistrai{" +
                "id=" + id +
                ", vardas_pavarde='" + vardas_pavarde + '\'' +
                ", specializacijaMeistro=" + specializacijaMeistro +
                ", meistroAutoservisas=" + meistroAutoservisas +
                ", meistroVertinimas=" + meistroVertinimas +
                '}';
    }
}
