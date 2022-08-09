package lt.autoservis.u5.Component;

import lt.autoservis.u5.model.entity.Vartotojas;
import lt.autoservis.u5.model.repository.RoleRepository;
import lt.autoservis.u5.model.repository.VartotojasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Set;

@Component
public class SetupDataLoader implements
        ApplicationListener<ContextRefreshedEvent>{


        boolean alreadySetup = false;

        @Autowired
        private VartotojasRepository vartotojuRepozitorija;

        @Autowired
        private RoleRepository roleRepository;

        @Autowired
        private PrivilegijosRepository privilegijosRepository;

   /*     @Autowired
        private BCryptPasswordEncoder passwordEncoder;*/

        @Override
        @Transactional
        public void onApplicationEvent(ContextRefreshedEvent event) {

        if (alreadySetup)
             return;
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
        Vartotojas vartotojas = new Vartotojas();
        vartotojas.setUsername("Test");
        vartotojas.setPassword("test");
//        vartotojas.setVartotojoRole (hashSet);
        vartotojas.setEnabled(true);
        vartotojuRepozitorija.save(vartotojas);

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

        Role role = roleRepository.findByName(name);
        if (role == null) {
            role = new Role(name);
            role.setPrivilegijuRoles(privilegijos);
            roleRepository.save(role);
        }
        return role;
    }
   }
