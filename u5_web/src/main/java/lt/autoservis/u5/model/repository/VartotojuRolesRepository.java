package lt.autoservis.u5.model.repository;

import lt.autoservis.u5.model.entity.Meistrai;
import lt.autoservis.u5.model.entity.VartotojuRoles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VartotojuRolesRepository extends JpaRepository<VartotojuRoles,Long> {
}
