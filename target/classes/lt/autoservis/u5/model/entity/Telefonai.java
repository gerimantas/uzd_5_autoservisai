package lt.autoservis.u5.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class Telefonai {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long numeris;

    @ManyToOne
    @JoinColumn(name = "autoservisai_id")

    @JsonIgnore
    private Autoservisai autoservisoTelefonas;

    public Telefonai() {
    }

    public Telefonai(long id, long numeris, Autoservisai autoservisoTelefonas) {
        this.id = id;
        this.numeris = numeris;
        this.autoservisoTelefonas = autoservisoTelefonas;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getNumeris() {
        return numeris;
    }

    public void setNumeris(long numeris) {
        this.numeris = numeris;
    }

    public Autoservisai getAutoservisoTelefonas() {
        return autoservisoTelefonas;
    }

    public void setAutoservisoTelefonas(Autoservisai autoservisoTelefonas) {
        this.autoservisoTelefonas = autoservisoTelefonas;
    }

    @Override
    public String toString() {
        return "Telefonai{" +
                "id=" + id +
                ", numeris=" + numeris +
                ", autoservisoTelefonas=" + autoservisoTelefonas +
                '}';
    }
}
