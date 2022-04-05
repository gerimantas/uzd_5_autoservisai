package lt.autoservis.u5.model.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Meistrai {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String vardas_pavarde;
    private long autoservisas_id;
    private long ivertinimas_id;

    @ManyToMany
    @JoinTable (
            name = "sujungimas_meistrai_specializacija",
            joinColumns = @JoinColumn(name = "meistrai_id"),
            inverseJoinColumns = @JoinColumn(name = "specializacija_id"))
    private Set<Specializacija> specializacijaMeistro;

    @OneToMany(mappedBy = "meistroAutoservisas")
    Set<Autoservisai> autoservisoMeistrai;

    public Meistrai() {
    }

    public Meistrai(long id, String vardas_pavarde, long autoservisas_id, long ivertinimas_id, Set<Specializacija> specializacijaMeistro, Set<Autoservisai> autoservisoMeistrai) {
        this.id = id;
        this.vardas_pavarde = vardas_pavarde;
        this.autoservisas_id = autoservisas_id;
        this.ivertinimas_id = ivertinimas_id;
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

    public long getAutoservisas_id() {
        return autoservisas_id;
    }

    public void setAutoservisas_id(long autoservisas_id) {
        this.autoservisas_id = autoservisas_id;
    }

    public long getIvertinimas_id() {
        return ivertinimas_id;
    }

    public void setIvertinimas_id(long ivertinimas_id) {
        this.ivertinimas_id = ivertinimas_id;
    }

    public Set<Specializacija> getSpecializacijaMeistro() {
        return specializacijaMeistro;
    }

    public void setSpecializacijaMeistro(Set<Specializacija> specializacijaMeistro) {
        this.specializacijaMeistro = specializacijaMeistro;
    }

    public Set<Autoservisai> getAutoservisoMeistrai() {
        return autoservisoMeistrai;
    }

    public void setAutoservisoMeistrai(Set<Autoservisai> autoservisoMeistrai) {
        this.autoservisoMeistrai = autoservisoMeistrai;
    }

    @Override
    public String toString() {
        return "Meistrai{" +
                "id=" + id +
                ", vardas_pavarde='" + vardas_pavarde + '\'' +
                ", autoservisas_id=" + autoservisas_id +
                ", ivertinimas_id=" + ivertinimas_id +
                ", specializacijaMeistro=" + specializacijaMeistro +
                ", autoservisoMeistrai=" + autoservisoMeistrai +
                '}';
    }
}
