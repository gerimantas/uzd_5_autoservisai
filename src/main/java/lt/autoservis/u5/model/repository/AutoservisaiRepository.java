package lt.autoservis.u5.model.repository;

import lt.autoservis.u5.model.entity.Autoservisai;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AutoservisaiRepository extends JpaRepository<Autoservisai,Long> {
    Autoservisai findByPavadinimas(String pavadinimas);

    Autoservisai findById(long id);



}
