package lt.autoservis.u5.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Privilegijos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @JsonIgnore
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
            name = "role_privilegija",
            joinColumns = @JoinColumn(name = "privilegija_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> rolesPrivilegijos;

    public Privilegijos() {
    }

    public Privilegijos(Long id, String name, Set<Role> rolesPrivilegijos) {
        this.id = id;
        this.name = name;
        this.rolesPrivilegijos = rolesPrivilegijos;
    }

    public Privilegijos(String name) {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Role> getRolesPrivilegijos() {
        return rolesPrivilegijos;
    }

    public void setRolesPrivilegijos(Set<Role> rolesPrivilegijos) {
        this.rolesPrivilegijos = rolesPrivilegijos;
    }

    @Override
    public String toString() {
        return "Privilegijos{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", rolesPrivilegijos=" + rolesPrivilegijos +
                '}';
    }
}
