package ua.help.agro.core.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ua.help.agro.core.domain.User;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    @Override
    List<User> findAll();

    User getUsersByEmailContaining(String email);
}
