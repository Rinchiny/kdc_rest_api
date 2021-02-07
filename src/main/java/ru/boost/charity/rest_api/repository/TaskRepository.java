package ru.boost.charity.rest_api.repository;

import org.springframework.data.repository.CrudRepository;
import ru.boost.charity.rest_api.entity.Task;
import ru.boost.charity.rest_api.entity.TaskStatus;
import ru.boost.charity.rest_api.entity.User;

import java.util.List;

public interface TaskRepository extends CrudRepository<Task, Long> {

    List<Task> findAllByTaskStatus (TaskStatus status);

    List<Task> findAllByReporter (User reporter);
}
