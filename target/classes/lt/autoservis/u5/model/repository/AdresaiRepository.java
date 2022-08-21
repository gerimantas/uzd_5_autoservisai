package lt.autoservis.u5.model.repository;

import lt.autoservis.u5.model.entity.Adresai;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdresaiRepository extends JpaRepository<Adresai,Long> {
    Adresai findById(long id);

}
