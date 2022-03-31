package lt.autoservis.u5.model.entity;


import javax.persistence.*;
import java.util.Set;

@Entity
public class Autoservisai {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long miestas_id;
    private String pavadinimas;
    private String vadovas;



        @ManyToMany
    @JoinTable (
            name = "sujungimas_autoservisai_specializacija",
            joinColumns = @JoinColumn(name = "autoservisai_id"),
            inverseJoinColumns = @JoinColumn(name = "specializacija_id"))
    private Set<Specializacija> autoservisoSpecializacija;

//    @ManyToMany
//    @JoinTable (
//            name = "sujungimas_autoservisai_meistrai",
//            joinColumns = @JoinColumn(name = "autoservisai_id"),
//            inverseJoinColumns = @JoinColumn(name = "meistrai_id"))
//    private Set<Meistrai> autoservisoMeistrai;
//
//    @ManyToOne
//    @JoinColumn(name = "vartotojas_id")
//    private Vartotojas irasoKurejas;

    public Autoservisai() {
    }

    public Autoservisai(long id, long miestas_id, String pavadinimas, String vadovas, Set<Specializacija> autoservisoSpecializacija) {
        this.id = id;
        this.miestas_id = miestas_id;
        this.pavadinimas = pavadinimas;
        this.vadovas = vadovas;
        this.autoservisoSpecializacija = autoservisoSpecializacija;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getMiestas_id() {
        return miestas_id;
    }

    public void setMiestas_id(long miestas_id) {
        this.miestas_id = miestas_id;
    }

    public String getPavadinimas() {
        return pavadinimas;
    }

    public void setPavadinimas(String pavadinimas) {
        this.pavadinimas = pavadinimas;
    }

    public String getVadovas() {
        return vadovas;
    }

    public void setVadovas(String vadovas) {
        this.vadovas = vadovas;
    }

    public Set<Specializacija> getAutoservisoSpecializacija() {
        return autoservisoSpecializacija;
    }

    public void setAutoservisoSpecializacija(Set<Specializacija> autoservisoSpecializacija) {
        this.autoservisoSpecializacija = autoservisoSpecializacija;
    }

    @Override
    public String toString() {
        return "Autoservisai{" +
                "id=" + id +
                ", miestas_id=" + miestas_id +
                ", pavadinimas='" + pavadinimas + '\'' +
                ", vadovas='" + vadovas + '\'' +
                ", autoservisoSpecializacija=" + autoservisoSpecializacija +
                '}';
    }
}
