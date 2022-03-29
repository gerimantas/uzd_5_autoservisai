package lt.autoservis.u5.model.entity;


import javax.persistence.*;
import java.util.Set;

@Entity
public class Autoservisai {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String pavadinimas;
    private String adresas;
    private String telefonas;
    private String vadovas;



        @ManyToMany
    @JoinTable (
            name = "sujungimas_autoservisai_specializacija",
            joinColumns = @JoinColumn(name = "autoservisai_id"),
            inverseJoinColumns = @JoinColumn(name = "specializacija_id"))
    private Set<Specializacija> autoservisoSpecializacija;

    @ManyToMany
    @JoinTable (
            name = "sujungimas_autoservisai_meistrai",
            joinColumns = @JoinColumn(name = "autoservisai_id"),
            inverseJoinColumns = @JoinColumn(name = "meistrai_id"))
    private Set<Meistrai> autoservisoMeistrai;

    @ManyToOne
    @JoinColumn(name = "vartotojas_id")
    private Vartotojas irasoKurejas;

    public Autoservisai() {
    }

    public Autoservisai(long id, String pavadinimas, String adresas, String telefonas, String vadovas, Set<Specializacija> autoservisoSpecializacija, Set<Meistrai> autoservisoMeistrai, Vartotojas irasoKurejas) {
        this.id = id;
        this.pavadinimas = pavadinimas;
        this.adresas = adresas;
        this.telefonas = telefonas;
        this.vadovas = vadovas;
        this.autoservisoSpecializacija = autoservisoSpecializacija;
        this.autoservisoMeistrai = autoservisoMeistrai;
        this.irasoKurejas = irasoKurejas;
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

    public String getAdresas() {
        return adresas;
    }

    public void setAdresas(String adresas) {
        this.adresas = adresas;
    }

    public String getTelefonas() {
        return telefonas;
    }

    public void setTelefonas(String telefonas) {
        this.telefonas = telefonas;
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

    public Set<Meistrai> getAutoservisoMeistrai() {
        return autoservisoMeistrai;
    }

    public void setAutoservisoMeistrai(Set<Meistrai> autoservisoMeistrai) {
        this.autoservisoMeistrai = autoservisoMeistrai;
    }

    public Vartotojas getIrasoKurejas() {
        return irasoKurejas;
    }

    public void setIrasoKurejas(Vartotojas irasoKurejas) {
        this.irasoKurejas = irasoKurejas;
    }

    @Override
    public String toString() {
        return "Autoservisai{" +
                "id=" + id +
                ", pavadinimas='" + pavadinimas + '\'' +
                ", adresas='" + adresas + '\'' +
                ", telefonas='" + telefonas + '\'' +
                ", vadovas='" + vadovas + '\'' +
                ", autoservisoSpecializacija=" + autoservisoSpecializacija +
                ", autoservisoMeistrai=" + autoservisoMeistrai +
                ", irasoKurejas=" + irasoKurejas +
                '}';
    }
}
