package lt.autoservis.u5.model.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
public class Vartotojas {
    @Id
    @GeneratedValue
    long id;
    String username;
    String passsword;

    @OneToMany(mappedBy = "irasoKurejas")
    Set<Autoservisai> vartotojoAutoservisai;

    public Vartotojas() {
    }

    public Vartotojas(long id, String username, String passsword, Set<Autoservisai> vartotojoAutoservisai) {
        this.id = id;
        this.username = username;
        this.passsword = passsword;
        this.vartotojoAutoservisai = vartotojoAutoservisai;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasssword() {
        return passsword;
    }

    public void setPasssword(String passsword) {
        this.passsword = passsword;
    }

    public Set<Autoservisai> getVartotojoAutoservisai() {
        return vartotojoAutoservisai;
    }

    public void setVartotojoAutoservisai(Set<Autoservisai> vartotojoAutoservisai) {
        this.vartotojoAutoservisai = vartotojoAutoservisai;
    }

    @Override
    public String toString() {
        return "Vartotojas{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", passsword='" + passsword + '\'' +
                ", vartotojoAutoservisai=" + vartotojoAutoservisai +
                '}';
    }

}

