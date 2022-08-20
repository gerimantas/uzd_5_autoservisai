package lt.autoservis.u5.Component;

import lt.autoservis.u5.model.entity.Privilegijos;
import lt.autoservis.u5.model.entity.Role;
import lt.autoservis.u5.model.entity.Vartotojas;
import lt.autoservis.u5.model.repository.PrivilegijosRepository;
import lt.autoservis.u5.model.repository.RoleRepository;
import lt.autoservis.u5.model.repository.VartotojasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Component
public class SetupDataLoader implements
        ApplicationListener<ContextRefreshedEvent>{


        boolean alreadySetup = false;

        @Autowired
        private VartotojasRepository vartotojasRepozitorija;

        @Autowired
        private RoleRepository roleRepository;

        @Autowired
        private PrivilegijosRepository privilegijosRepository;

   /*     @Autowired
        private BCryptPasswordEncoder passwordEncoder;*/

        @Override
        @Transactional
        public void onApplicationEvent(ContextRefreshedEvent event) {
        if (alreadySetup) {
            return;
        }

        Privilegijos readPrivilegijos
                = createPrivilegeIfNotFound("READ_PRIVILEGE");
        Privilegijos writePrivilege
                = createPrivilegeIfNotFound("WRITE_PRIVILEGE");

        Set<Privilegijos> adminoPriviliegijos = new HashSet<>();
        adminoPriviliegijos.add(readPrivilegijos);
        adminoPriviliegijos.add(writePrivilege);

        Set<Privilegijos> vartotojoPrivilegijos = new HashSet<>();
        vartotojoPrivilegijos.add(readPrivilegijos);

        createRoleIfNotFound("ROLE_ADMIN", adminoPriviliegijos);
        createRoleIfNotFound("ROLE_USER", vartotojoPrivilegijos);

        Role adminRole = roleRepository.findByName("ROLE_ADMIN");
        Set<Role> hashSet = new HashSet<Role>();
        hashSet.add (adminRole);
//        Vartotojas vartotojas = new Vartotojas();
//        vartotojas.setUsername("Test");
//        vartotojas.setPassword("test");
//        vartotojas.setRoles (hashSet);
//        vartotojas.setEnabled(true);
//        vartotojuRepozitorija.save(vartotojas);

        alreadySetup = true;

    }

     @Transactional
     Privilegijos createPrivilegeIfNotFound(String name) {

          Privilegijos privilegijos = privilegijosRepository.findByName(name);
          if (privilegijos == null) {
               privilegijos = new Privilegijos(name);
               privilegijosRepository.save(privilegijos);
          }
          return privilegijos;
     }
    @Transactional
    Role createRoleIfNotFound (String name, Set<Privilegijos> privilegijos) {

        Role roles = roleRepository.findByName(name);
        if (roles == null) {
            roles = new Role(name);
            roles.setPrivilegijuRoles(privilegijos);
            roleRepository.save(roles);
        }
        return roles;
    }

    @Transactional
       Vartotojas createUserIfNotFound(String username, String password, Collection<Role> roles) {
        VartotojasRepository vartotojasRepository = null;
        Vartotojas user = vartotojasRepository.findByUsername(username);
        if (user == null) {
            user = new Vartotojas();
            user.setUsername(username);
            user.setEnabled(true);
        }
        user.setRoles((Set<Role>) roles);
        user = vartotojasRepository.save(user);
        return user;
    }

   }
