package polytech.service_emplacements.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import polytech.service_emplacements.model.Commodite;

@Repository
public interface CommoditeRepository extends JpaRepository<Commodite, Long> {}
