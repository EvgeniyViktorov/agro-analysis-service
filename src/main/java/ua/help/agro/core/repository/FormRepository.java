package ua.help.agro.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.help.agro.core.domain.Form;

@Repository
public interface FormRepository extends JpaRepository<Form, Long> {

}
