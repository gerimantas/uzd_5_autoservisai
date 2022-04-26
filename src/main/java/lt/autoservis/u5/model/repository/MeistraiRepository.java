package lt.autoservis.u5.model.repository;

import lt.autoservis.u5.model.entity.Meistrai;
import lt.autoservis.u5.model.entity.Specializacija;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MeistraiRepository extends JpaRepository<Meistrai,Long>{
    Meistrai findById(long id);

    }


