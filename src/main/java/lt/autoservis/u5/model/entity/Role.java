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

    public Role() {
    }

    public Role(Integer id, String name, Set<Privilegijos> privilegijuRoles) {
        this.id = id;
        this.name = name;
        this.privilegijuRoles = privilegijuRoles;


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

    public Set<Privilegijos> getPrivilegijuRoles() {
        return privilegijuRoles;
    }

    public void setPrivilegijuRoles(Set<Privilegijos> privilegijuRoles) {
        this.privilegijuRoles = privilegijuRoles;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", privilegijuRoles=" + privilegijuRoles +
                '}';
    }
}

