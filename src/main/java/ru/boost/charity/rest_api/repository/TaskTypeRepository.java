package ru.boost.charity.rest_api.repository;

import org.springframework.data.repository.CrudRepository;
import ru.boost.charity.rest_api.entity.TaskType;

public interface TaskTypeRepository extends CrudRepository<TaskType, Long> {

    TaskType findByTitle(String title);
}
