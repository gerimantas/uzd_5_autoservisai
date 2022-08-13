package lt.autoservis.u5.model.repository;

import lt.autoservis.u5.model.entity.Privilegijos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrivilegijosRepository extends JpaRepository<Privilegijos, Long> {
    Privilegijos findById(long id);
    Privilegijos findByName(String name);
}
