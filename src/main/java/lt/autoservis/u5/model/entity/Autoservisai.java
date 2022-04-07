package lt.autoservis.u5.model.entity;


import javax.persistence.*;
import java.util.Set;

@Entity
public class Autoservisai {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String pavadinimas;
    private String vadovas;



    @ManyToMany
    @JoinTable (
            name = "sujungimas_autoservisai_specializacija",
            joinColumns = @JoinColumn(name = "autoservisai_id"),
            inverseJoinColumns = @JoinColumn(name = "specializacija_id"))
    private Set<Specializacija> autoservisoSpecializacija;

    @ManyToMany
    @JoinTable (
            name = "sujungimas_autoservisai_miestai",
            joinColumns = @JoinColumn(name = "autoservisai_id"),
            inverseJoinColumns = @JoinColumn(name = "miestai_id"))
    private Set<Miestai> autoservisoMiestas;

    @OneToMany(mappedBy = "autoservisoMeistrai")
    Set<Meistrai> autoservisoMeistrai;

    @OneToMany(mappedBy = "autoservisoAdresas")
    Set<Adresai> autoservisoAdresas;

    @OneToMany(mappedBy = "autoservisoTelefonas")
    Set<Telefonai> autoservisoTelefonas;



    public Autoservisai() {
    }

    public Autoservisai(long id, String pavadinimas, String vadovas, Set<Specializacija> autoservisoSpecializacija, Set<Miestai> autoservisoMiestas, Set<Meistrai> autoservisoMeistrai, Set<Adresai> autoservisoAdresas, Set<Telefonai> autoservisoTelefonas) {
        this.id = id;
        this.pavadinimas = pavadinimas;
        this.vadovas = vadovas;
        this.autoservisoSpecializacija = autoservisoSpecializacija;
        this.autoservisoMiestas = autoservisoMiestas;
        this.autoservisoMeistrai = autoservisoMeistrai;
        this.autoservisoAdresas = autoservisoAdresas;
        this.autoservisoTelefonas = autoservisoTelefonas;
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

    public Set<Miestai> getAutoservisoMiestas() {
        return autoservisoMiestas;
    }

    public void setAutoservisoMiestas(Set<Miestai> autoservisoMiestas) {
        this.autoservisoMiestas = autoservisoMiestas;
    }

    public Set<Meistrai> getAutoservisoMeistrai() {
        return autoservisoMeistrai;
    }

    public void setAutoservisoMeistrai(Set<Meistrai> autoservisoMeistrai) {
        this.autoservisoMeistrai = autoservisoMeistrai;
    }

    public Set<Adresai> getAutoservisoAdresas() {
        return autoservisoAdresas;
    }

    public void setAutoservisoAdresas(Set<Adresai> autoservisoAdresas) {
        this.autoservisoAdresas = autoservisoAdresas;
    }

    public Set<Telefonai> getAutoservisoTelefonas() {
        return autoservisoTelefonas;
    }

    public void setAutoservisoTelefonas(Set<Telefonai> autoservisoTelefonas) {
        this.autoservisoTelefonas = autoservisoTelefonas;
    }

    @Override
    public String toString() {
        return "Autoservisai{" +
                "id=" + id +
                ", pavadinimas='" + pavadinimas + '\'' +
                ", vadovas='" + vadovas + '\'' +
                ", autoservisoSpecializacija=" + autoservisoSpecializacija +
                ", autoservisoMiestas=" + autoservisoMiestas +
                ", autoservisoMeistrai=" + autoservisoMeistrai +
                ", autoservisoAdresas=" + autoservisoAdresas +
                ", autoservisoTelefonas=" + autoservisoTelefonas +
                '}';
    }
}
