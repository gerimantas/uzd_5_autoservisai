package lt.autoservis.u5.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Vartotojas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String username;
    private String password;
    private boolean enabled;

    @JsonIgnore
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(name = "vartotojas_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> rolesVartotoju = new HashSet<>();


    @ManyToMany
    @JoinTable(
            name = "vartotoju_vertinimai",
            joinColumns = @JoinColumn(name = "vartotojo_id"),
            inverseJoinColumns = @JoinColumn(name = "vertinimas_id")
    )
    private Set<Vertinimas> vartotojuVertinimai;

    public Vartotojas() {
    }

    public Vartotojas(long id, String username, String password, boolean enabled, Set<Role> rolesVartotoju, Set<Vertinimas> vartotojuVertinimai) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.enabled = enabled;
        this.rolesVartotoju = rolesVartotoju;
        this.vartotojuVertinimai = vartotojuVertinimai;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Set<Role> getRolesVartotoju() {
        return rolesVartotoju;
    }

    public void setRolesVartotoju(Set<Role> rolesVartotoju) {
        this.rolesVartotoju = rolesVartotoju;
    }

    public Set<Vertinimas> getVartotojuVertinimai() {
        return vartotojuVertinimai;
    }

    public void setVartotojuVertinimai(Set<Vertinimas> vartotojuVertinimai) {
        this.vartotojuVertinimai = vartotojuVertinimai;
    }

    @Override
    public String toString() {
        return "Vartotojas{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", enabled=" + enabled +
                ", rolesVartotoju=" + rolesVartotoju +
                ", vartotojuVertinimai=" + vartotojuVertinimai +
                '}';
    }

}
