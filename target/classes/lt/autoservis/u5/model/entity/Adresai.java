package lt.autoservis.u5.model.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class Adresai {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String gatve;
    private long namas;
    private long pasto_kodas;


    @ManyToOne
    @JoinColumn(name = "autoservisai_id")

    @JsonIgnore
    private Autoservisai autoservisoAdresas;

    public Adresai() {
    }

    public Adresai(long id, String gatve, long namas, long pasto_kodas, Autoservisai autoservisoAdresas) {
        this.id = id;
        this.gatve = gatve;
        this.namas = namas;
        this.pasto_kodas = pasto_kodas;
        this.autoservisoAdresas = autoservisoAdresas;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getGatve() {
        return gatve;
    }

    public void setGatve(String gatve) {
        this.gatve = gatve;
    }

    public long getNamas() {
        return namas;
    }

    public void setNamas(long namas) {
        this.namas = namas;
    }

    public long getPasto_kodas() {
        return pasto_kodas;
    }

    public void setPasto_kodas(long pasto_kodas) {
        this.pasto_kodas = pasto_kodas;
    }

    public Autoservisai getAutoservisoAdresas() {
        return autoservisoAdresas;
    }

    public void setAutoservisoAdresas(Autoservisai autoservisoAdresas) {
        this.autoservisoAdresas = autoservisoAdresas;
    }

    @Override
    public String toString() {
        return "Adresai{" +
                "id=" + id +
                ", gatve='" + gatve + '\'' +
                ", namas=" + namas +
                ", pasto_kodas=" + pasto_kodas +
                ", autoservisoAdresas=" + autoservisoAdresas +
                '}';
    }
}
