package ua.help.agro.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.help.agro.core.domain.PlantType;

@Repository
public interface PlantTypeRepository extends JpaRepository<PlantType, Long> {
}
