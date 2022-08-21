package lt.autoservis.u5.security;

import lt.autoservis.u5.model.entity.Privilegijos;

import lt.autoservis.u5.model.entity.Role;
import lt.autoservis.u5.model.entity.Vartotojas;
import lt.autoservis.u5.model.repository.RoleRepository;
import lt.autoservis.u5.model.repository.VartotojasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import org.springframework.security.access.hierarchicalroles.RoleHierarchy;
import org.springframework.security.access.hierarchicalroles.RoleHierarchyImpl;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private VartotojasRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {

        Vartotojas user = VartotojasRepository.findByUsername(username);

        if (user == null) {
            return new org.springframework.security.core.userdetails.User(
                    " ", " ", true, true, true, true,
                    getAuthorities(Arrays.asList(
                            roleRepository.findByName("ROLE_USER"))));
//            throw new UsernameNotFoundException("Could not find user");
        }
        return new org.springframework.security.core.userdetails.User(
                user.getUsername(), user.getPassword(), user.getEnabled(), true, true,
                true, getAuthorities(user.getRoles()));
//        return new MyUserDetails(user);
    }
    private Collection<? extends GrantedAuthority> getAuthorities(
            Collection<Role> roles) {

        return getGrantedAuthorities(getPrivileges(roles));
    }

    private List<String> getPrivileges(Collection<Role> roles) {

        List<String> privileges = new ArrayList<>();
        List<Privilegijos> collection = new ArrayList<>();
        for (Role role : roles) {
            privileges.add(role.getName());
            collection.addAll(role.getPrivilegijuRoles());
        }
        for (Privilegijos item : collection) {
            privileges.add(item.getName());
        }
        return privileges;
    }

    private List<GrantedAuthority> getGrantedAuthorities(List<String> privileges) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (String privilege : privileges) {
            authorities.add(new SimpleGrantedAuthority(privilege));
        }
        return authorities;
    }

    @Bean
    public RoleHierarchy roleHierarchy() {
        RoleHierarchyImpl roleHierarchy = new RoleHierarchyImpl();
        String hierarchy = "ROLE_ADMIN > ROLE_STAFF \n ROLE_STAFF > ROLE_USER";
        roleHierarchy.setHierarchy(hierarchy);
        return roleHierarchy;
    }

}