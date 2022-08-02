package lt.autoservis.u5.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
public class Vertinimas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private int balas;
    private LocalDate data;
    private String komentaras;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "meistrai_id")
    private Meistrai meistroVertinimas;


    @ManyToMany
    @JoinTable(
            name = "vartotoju_vertinimai",
            joinColumns = @JoinColumn(name = "vertinimas_id"),
            inverseJoinColumns = @JoinColumn(name = "vartotojo_id")
    )
    private Set<Vartotojas> vartotojaiKurieVertino;

    public Vertinimas() {
    }

    public Vertinimas(long id, int balas, LocalDate data, String komentaras, Meistrai meistroVertinimas, Set<Vartotojas> vartotojaiKurieVertino) {
        this.id = id;
        this.balas = balas;
        this.data = data;
        this.komentaras = komentaras;
        this.meistroVertinimas = meistroVertinimas;
        this.vartotojaiKurieVertino = vartotojaiKurieVertino;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getBalas() {
        return balas;
    }

    public void setBalas(int balas) {
        this.balas = balas;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getKomentaras() {
        return komentaras;
    }

    public void setKomentaras(String komentaras) {
        this.komentaras = komentaras;
    }

    public Meistrai getMeistroVertinimas() {
        return meistroVertinimas;
    }

    public void setMeistroVertinimas(Meistrai meistroVertinimas) {
        this.meistroVertinimas = meistroVertinimas;
    }

    public Set<Vartotojas> getVartotojaiKurieVertino() {
        return vartotojaiKurieVertino;
    }

    public void setVartotojaiKurieVertino(Set<Vartotojas> vartotojaiKurieVertino) {
        this.vartotojaiKurieVertino = vartotojaiKurieVertino;
    }

    @Override
    public String toString() {
        return "Vertinimas{" +
                "id=" + id +
                ", balas=" + balas +
                ", data=" + data +
                ", komentaras='" + komentaras + '\'' +
                ", meistroVertinimas=" + meistroVertinimas +
                ", vartotojaiKurieVertino=" + vartotojaiKurieVertino +
                '}';
    }
}
