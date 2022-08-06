package lt.autoservis.u5.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    @JsonIgnore
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "role_privilegija",
            joinColumns = @JoinColumn(name = "role_id"),
            inverseJoinColumns = @JoinColumn(name = "privilegija_id")
    )
    private Set<Privilegijos> privilegijuRoles = new HashSet<>();

    @JsonIgnore
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(name = "role_id"),
            inverseJoinColumns = @JoinColumn(name = "vartotojas_id")
    )
    private Set<Vartotojas> vartotojuRoles = new HashSet<>();

    public Role(String name) {
    }

    public Role(Integer id, String name, Set<Privilegijos> privilegijuRoles, Set<Vartotojas> vartotojuRoles) {
        this.id = id;
        this.name = name;
        this.privilegijuRoles = privilegijuRoles;
        this.vartotojuRoles = vartotojuRoles;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Privilegijos> getPrivilegijuRoles() {
        return privilegijuRoles;
    }

    public void setPrivilegijuRoles(Set<Privilegijos> privilegijuRoles) {
        this.privilegijuRoles = privilegijuRoles;
    }

    public Set<Vartotojas> getVartotojuRoles() {
        return vartotojuRoles;
    }

    public void setVartotojuRoles(Set<Vartotojas> vartotojuRoles) {
        this.vartotojuRoles = vartotojuRoles;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", privilegijuRoles=" + privilegijuRoles +
                ", vartotojuRoles=" + vartotojuRoles +
                '}';
    }
}

