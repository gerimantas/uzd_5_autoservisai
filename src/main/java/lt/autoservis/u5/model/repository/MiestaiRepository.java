package lt.autoservis.u5.model.repository;

import lt.autoservis.u5.model.entity.Meistrai;
import lt.autoservis.u5.model.entity.Miestai;
import lt.autoservis.u5.model.entity.Specializacija;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MiestaiRepository extends JpaRepository<Miestai,Long> {
    Miestai findById(long id);
    Miestai findByPavadinimas(String pavadinimas);
}
