package ua.help.agro.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ua.help.agro.core.domain.Form;
import ua.help.agro.core.domain.User;

import java.util.List;

@Repository
public interface FormRepository extends JpaRepository<Form, Long> {

}
