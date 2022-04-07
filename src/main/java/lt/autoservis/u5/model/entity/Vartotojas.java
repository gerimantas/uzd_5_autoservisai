package lt.autoservis.u5.model.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Set;
//
//@Entity
//public class Vartotojas {
//    @Id
//    @GeneratedValue
//    long id;
//    String username;
//    String password;
//
//
//    @OneToMany(mappedBy = "vartotojuRoles")
//    Set<VartotojuRoles> vartotojoRole;
//
//    public Vartotojas() {
//    }
//
//    public Vartotojas(long id, String username, String password, Set<VartotojuRoles> vartotojoRole) {
//        this.id = id;
//        this.username = username;
//        this.password = password;
//        this.vartotojoRole = vartotojoRole;
//    }
//
//    public long getId() {
//        return id;
//    }
//
//    public void setId(long id) {
//        this.id = id;
//    }
//
//    public String getUsername() {
//        return username;
//    }
//
//    public void setUsername(String username) {
//        this.username = username;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    public Set<VartotojuRoles> getVartotojoRole() {
//        return vartotojoRole;
//    }
//
//    public void setVartotojoRole(Set<VartotojuRoles> vartotojoRole) {
//        this.vartotojoRole = vartotojoRole;
//    }
//
//    @Override
//    public String toString() {
//        return "Vartotojas{" +
//                "id=" + id +
//                ", username='" + username + '\'' +
//                ", password='" + password + '\'' +
//                ", vartotojoRole=" + vartotojoRole +
//                '}';
//    }
//}
//
