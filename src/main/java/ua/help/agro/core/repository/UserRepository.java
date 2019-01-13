package ua.help.agro.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ua.help.agro.core.domain.User;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User getUsersByEmailContaining(String email);

    User getUserById(Long id);
}
