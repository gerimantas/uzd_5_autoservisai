package lt.autoservis.u5.model.entity;


import javax.persistence.*;
import java.util.Set;

@Entity
public class Autoservisai {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String pavadinimas;
    private int ivertinimas;

    @ManyToMany
    @JoinTable (
            name = "sujungimas_servisai_kategorija",
            joinColumns = @JoinColumn(name = "serviso_id"),
            inverseJoinColumns = @JoinColumn(name = "kategorijos_id"))
    private Set<Autoservisai> autoservisoKategorija;






    public Autoservisai(long id, String pavadinimas, int ivertinimas, Set<Autoservisai> autoservisoKategorija) {
        this.id = id;
        this.pavadinimas = pavadinimas;
        this.ivertinimas = ivertinimas;
        this.autoservisoKategorija = autoservisoKategorija;
    }

    public Autoservisai() {
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

    public int getIvertinimas() {
        return ivertinimas;
    }

    public void setIvertinimas(int ivertinimas) {
        this.ivertinimas = ivertinimas;
    }

    public Set<Autoservisai> getAutoservisoKategorija() {
        return autoservisoKategorija;
    }

    public void setAutoservisoKategorija(Set<Autoservisai> autoservisoKategorija) {
        this.autoservisoKategorija = autoservisoKategorija;
    }

    @Override
    public String toString() {
        return "Autoservisai{" +
                "id=" + id +
                ", pavadinimas='" + pavadinimas + '\'' +
                ", ivertinimas=" + ivertinimas +
                ", autoservisoKategorija=" + autoservisoKategorija +
                '}';
    }
}
