package ru.boost.charity.rest_api.repository;

import org.springframework.data.repository.CrudRepository;
import ru.boost.charity.rest_api.model.User;

public interface UserRepository extends CrudRepository<User, Long> {
}
