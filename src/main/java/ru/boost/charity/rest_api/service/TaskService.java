package ru.boost.charity.rest_api.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.boost.charity.rest_api.entity.Task;
import ru.boost.charity.rest_api.entity.TaskStatus;
import ru.boost.charity.rest_api.entity.User;
import ru.boost.charity.rest_api.model.TaskModel;
import ru.boost.charity.rest_api.model.UserModel;
import ru.boost.charity.rest_api.repository.TaskRepository;
import ru.boost.charity.rest_api.repository.TaskStatusRepository;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskConverter taskConverter;
    private final TaskRepository taskRepository;
    private final TaskStatusRepository taskStatusRepository;

    public List<TaskModel> getAllTasks() {
        Iterable<Task> tasks = taskRepository.findAll();
        return StreamSupport.stream(tasks.spliterator(), false)
                .map(taskConverter::entityToModel)
                .collect(Collectors.toList());
    }

    public List<TaskModel> getAllTasksByStatus(String title) {
        TaskStatus taskStatus = taskStatusRepository.findByTitle(title);
        Iterable<Task> tasks = taskRepository.findAllByTaskStatus(taskStatus);
        return StreamSupport.stream(tasks.spliterator(), false)
                .map(taskConverter::entityToModel)
                .collect(Collectors.toList());
    }
}
