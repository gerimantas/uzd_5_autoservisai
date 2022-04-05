package lt.autoservis.u5.model.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Specializacija {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String pavadinimas;

    @ManyToMany
    @JoinTable(
            name = "sujungimas_autoservisai_specializacija",
            joinColumns = @JoinColumn(name = "specializacija_id"),
            inverseJoinColumns = @JoinColumn(name = "autoservisai_id"))
    private Set<Autoservisai> specializacijaAutoserviso;

    @ManyToMany
    @JoinTable(
            name = "sujungimas_meistrai_specializacija",
            joinColumns = @JoinColumn(name = "specializacija_id"),
            inverseJoinColumns = @JoinColumn(name = "meistrai_id"))
    private Set<Meistrai> specializacijaMeistro;


    public Specializacija() {
    }

    public Specializacija(long id, String pavadinimas, Set<Autoservisai> specializacijaAutoserviso, Set<Meistrai> specializacijaMeistro) {
        this.id = id;
        this.pavadinimas = pavadinimas;
        this.specializacijaAutoserviso = specializacijaAutoserviso;
        this.specializacijaMeistro = specializacijaMeistro;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPavadinimas() {
        return pavadinimas;
    }

    public void setPavadinimas(String pavadinimas) {
        this.pavadinimas = pavadinimas;
    }

    public Set<Autoservisai> getSpecializacijaAutoserviso() {
        return specializacijaAutoserviso;
    }

    public void setSpecializacijaAutoserviso(Set<Autoservisai> specializacijaAutoserviso) {
        this.specializacijaAutoserviso = specializacijaAutoserviso;
    }

    public Set<Meistrai> getSpecializacijaMeistro() {
        return specializacijaMeistro;
    }

    public void setSpecializacijaMeistro(Set<Meistrai> specializacijaMeistro) {
        this.specializacijaMeistro = specializacijaMeistro;
    }

    @Override
    public String toString() {
        return "Specializacija{" +
                "id=" + id +
                ", pavadinimas='" + pavadinimas + '\'' +
                ", specializacijaAutoserviso=" + specializacijaAutoserviso +
                ", specializacijaMeistro=" + specializacijaMeistro +
                '}';
    }
}

