package lt.autoservis.u5.model.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Miestai {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String pavadinimas;

    @ManyToMany
    @JoinTable (
            name = "sujungimas_autoservisai_miestai",
            joinColumns = @JoinColumn(name = "miestai_id"),
            inverseJoinColumns = @JoinColumn(name = "autoservisai_id"))
    private Set<Autoservisai> autoservisoMiestas;

    public Miestai() {
    }

    public Miestai(long id, String pavadinimas, Set<Autoservisai> autoservisoMiestas) {
        this.id = id;
        this.pavadinimas = pavadinimas;
        this.autoservisoMiestas = autoservisoMiestas;
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

    public Set<Autoservisai> getAutoservisoMiestas() {
        return autoservisoMiestas;
    }

    public void setAutoservisoMiestas(Set<Autoservisai> autoservisoMiestas) {
        this.autoservisoMiestas = autoservisoMiestas;
    }

    @Override
    public String toString() {
        return "Miestai{" +
                "id=" + id +
                ", pavadinimas='" + pavadinimas + '\'' +
                ", autoservisoMiestas=" + autoservisoMiestas +
                '}';
    }
}
