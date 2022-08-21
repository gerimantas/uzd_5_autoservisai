package lt.autoservis.u5.model.repository;

import lt.autoservis.u5.model.entity.Vartotojas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface VartotojasRepository extends JpaRepository<Vartotojas,Long> {
    Vartotojas findById(long id);

    static Vartotojas findByUsername(String username) {
        return null;
    }

//    @Query("SELECT u FROM Vartotojas u WHERE u.username = :username")
//    public static Vartotojas getUserByUsername(@Param("username") String username) {
//        return null;
//    }
}


