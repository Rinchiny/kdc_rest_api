package ru.boost.charity.rest_api.repository;

import org.springframework.data.repository.CrudRepository;
import ru.boost.charity.rest_api.model.Task;

public interface TaskRepository extends CrudRepository<Task, Long> {
}
