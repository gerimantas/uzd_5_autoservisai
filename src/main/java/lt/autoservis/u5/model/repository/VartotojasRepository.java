package lt.autoservis.u5.model.repository;

import lt.autoservis.u5.model.entity.Vartotojas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VartotojasRepository extends JpaRepository<Vartotojas,Long> {
    Vartotojas findById(long id);
    Vartotojas findByUsername(String username);
    Vartotojas findByActivationCode(String code);
}


