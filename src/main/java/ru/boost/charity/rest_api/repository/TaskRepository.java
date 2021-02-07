package ru.boost.charity.rest_api.repository;

import org.springframework.data.repository.CrudRepository;
import ru.boost.charity.rest_api.entity.Task;
import ru.boost.charity.rest_api.entity.TaskStatus;
import ru.boost.charity.rest_api.entity.TaskType;
import ru.boost.charity.rest_api.entity.User;

public interface TaskRepository extends CrudRepository<Task, Long> {

    Iterable<Task> findAllByTaskStatus (TaskStatus status);

    Iterable<Task> findAllByReporter (User reporter);

    Iterable<Task> findAllByExecutor (User executor);

    Iterable<Task> findAllByLocation (String location);

    Iterable<Task> findAllByTaskType (TaskType type);

    Iterable<Task> findAllByParentTask (Task task);
}
