package lt.autoservis.u5.model.repository;

import lt.autoservis.u5.model.entity.Specializacija;
import lt.autoservis.u5.model.entity.Telefonai;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TelefonaiRepository extends JpaRepository<Telefonai,Long> {
    Telefonai findById(long id);
}


