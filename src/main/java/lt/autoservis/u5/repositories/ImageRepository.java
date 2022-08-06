package lt.autoservis.u5.repositories;

import lt.autoservis.u5.models.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, Long> {
}
