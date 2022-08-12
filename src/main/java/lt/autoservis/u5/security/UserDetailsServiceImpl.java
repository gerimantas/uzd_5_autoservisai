package lt.autoservis.u5.security;

import lt.autoservis.u5.model.entity.Role;
import lt.autoservis.u5.model.entity.Vartotojas;
import lt.autoservis.u5.model.repository.VartotojasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Collections;

public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private VartotojasRepository vartotojasRepository;

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        Vartotojas vartotojas = vartotojasRepository.findByUsername(username);

        if (vartotojas == null) {
            throw new UsernameNotFoundException("Could not find user");
        }

        return new MyUserDetails(vartotojas);
    }

    public boolean addUser(Vartotojas vartotojas) {
        Vartotojas userFromDb = vartotojasRepository.findByUsername(vartotojas.getUsername());

        if (userFromDb != null) {
            return false;
        }

        vartotojas.setActive(true);
        vartotojas.setRoles(Collections.singleton(Role.name));
//        vartotojas.setActivationCode(UUID.randomUUID().toString());
        vartotojas.setPassword(passwordEncoder.encode(vartotojas.getPassword()));

        vartotojasRepository.save(vartotojas);

        return true;
    }

}