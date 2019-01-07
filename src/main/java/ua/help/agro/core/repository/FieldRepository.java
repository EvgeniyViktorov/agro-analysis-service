package ua.help.agro.core.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ua.help.agro.core.domain.Field;

@Repository
public interface FieldRepository extends CrudRepository<Field, Long> {
}
