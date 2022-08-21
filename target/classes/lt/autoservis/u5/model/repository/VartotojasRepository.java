package lt.autoservis.u5.model.repository;

import lt.autoservis.u5.model.entity.Vartotojas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface VartotojasRepository extends CrudRepository<Vartotojas,Long> {
    Vartotojas findById(long id);
    Vartotojas findByUsername(String username);

    @Query("SELECT u FROM User u WHERE u.username = :username")
    public Vartotojas getUserByUsername(@Param("username") String username);
}


