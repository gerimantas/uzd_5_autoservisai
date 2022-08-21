package lt.autoservis.u5.model.repository;

import lt.autoservis.u5.model.entity.Vertinimas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VertinimasRepository extends JpaRepository<Vertinimas,Long> {
    Vertinimas findById(long id);
    Vertinimas findByBalas(long id);
}
