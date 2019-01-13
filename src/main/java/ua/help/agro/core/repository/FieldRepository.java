package ua.help.agro.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ua.help.agro.core.domain.Field;

@Repository
public interface FieldRepository extends JpaRepository<Field, Long> {
}
