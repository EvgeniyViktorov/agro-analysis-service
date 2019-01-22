package ua.help.agro.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.help.agro.core.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User getUsersByEmailContaining(String email);

    User getUserById(Long id);
}
