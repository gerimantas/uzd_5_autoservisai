package lt.autoservis.u5.model.entity;

import javax.persistence.*;

@Entity
public class VartotojuRoles {
    @Id
    @GeneratedValue
    long id;
    String pavadinimas;


    @ManyToOne
    @JoinColumn(name = "vartotojas_id")
    private Vartotojas vartotojoRole;

    public VartotojuRoles() {
    }

    public VartotojuRoles(long id, String pavadinimas, Vartotojas vartotojoRole) {
        this.id = id;
        this.pavadinimas = pavadinimas;
        this.vartotojoRole = vartotojoRole;
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

    public Vartotojas getVartotojoRole() {
        return vartotojoRole;
    }

    public void setVartotojoRole(Vartotojas vartotojoRole) {
        this.vartotojoRole = vartotojoRole;
    }

    @Override
    public String toString() {
        return "VartotojuRoles{" +
                "id=" + id +
                ", pavadinimas='" + pavadinimas + '\'' +
                ", vartotojoRole=" + vartotojoRole +
                '}';
    }
}
