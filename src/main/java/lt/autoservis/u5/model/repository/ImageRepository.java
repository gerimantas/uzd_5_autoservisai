package lt.autoservis.u5.model.repository;

import lt.autoservis.u5.model.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, Long> {
}
