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
    private static Set<Privilegijos> privilegijuRoles = new HashSet<>();

    @JsonIgnore
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(name = "role_id"),
            inverseJoinColumns = @JoinColumn(name = "vartotojas_id")
    )
    private Set<Role> vartotojuRoles = new HashSet<>();

    public Role() {
    }

    public Role(Integer id, String name, Set<Role> vartotojuRoles) {
        this.id = id;
        this.name = name;
        this.vartotojuRoles = vartotojuRoles;
    }

    public Role(String name) {
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

    public static Set<Privilegijos> getPrivilegijuRoles() {
        return privilegijuRoles;
    }

    public static void setPrivilegijuRoles(Set<Privilegijos> privilegijuRoles) {
        Role.privilegijuRoles = privilegijuRoles;
    }

    public Set<Role> getVartotojuRoles() {
        return vartotojuRoles;
    }

    public void setVartotojuRoles(Set<Role> vartotojuRoles) {
        this.vartotojuRoles = vartotojuRoles;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", vartotojai=" + vartotojuRoles +
                '}';
    }
}

