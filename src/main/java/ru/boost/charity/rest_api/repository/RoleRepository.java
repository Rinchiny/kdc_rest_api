package ru.boost.charity.rest_api.repository;

import org.springframework.data.repository.CrudRepository;
import ru.boost.charity.rest_api.entity.Role;

public interface RoleRepository extends CrudRepository<Role, Long> {
}
