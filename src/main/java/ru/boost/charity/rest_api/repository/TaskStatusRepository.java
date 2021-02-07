package ru.boost.charity.rest_api.repository;

import org.springframework.data.repository.CrudRepository;
import ru.boost.charity.rest_api.entity.TaskStatus;

public interface TaskStatusRepository extends CrudRepository<TaskStatus, Long> {

    TaskStatus findByTitle(String title);
}
