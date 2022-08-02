package lt.autoservis.u5.model.repository;

import lt.autoservis.u5.model.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {
    Role findById(long id);
    Role findByName(String name);
}