package ru.boost.charity.rest_api.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.boost.charity.rest_api.entity.Task;
import ru.boost.charity.rest_api.entity.TaskStatus;
import ru.boost.charity.rest_api.entity.TaskType;
import ru.boost.charity.rest_api.entity.User;
import ru.boost.charity.rest_api.model.TaskModel;
import ru.boost.charity.rest_api.repository.TaskRepository;
import ru.boost.charity.rest_api.repository.TaskStatusRepository;
import ru.boost.charity.rest_api.repository.TaskTypeRepository;
import ru.boost.charity.rest_api.repository.UserRepository;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskConverter taskConverter;
    private final UserRepository userRepository;
    private final TaskRepository taskRepository;
    private final TaskTypeRepository taskTypeRepository;
    private final TaskStatusRepository taskStatusRepository;

    public List<TaskModel> getAllTasks() {
        Iterable<Task> tasks = taskRepository.findAll();
        return StreamSupport.stream(tasks.spliterator(), false)
                .map(taskConverter::entityToModel)
                .collect(Collectors.toList());
    }

    public List<TaskModel> getAllTasksByStatusTitle(String title) {
        TaskStatus taskStatus = taskStatusRepository.findByTitle(title);
        Iterable<Task> tasks = taskRepository.findAllByTaskStatus(taskStatus);
        return StreamSupport.stream(tasks.spliterator(), false)
                .map(taskConverter::entityToModel)
                .collect(Collectors.toList());
    }

    public TaskModel getTaskById(Long taskId) {
        return taskConverter.entityToModel(taskRepository.findById(taskId)
                .orElseThrow(EntityNotFoundException::new));
    }

    public List<TaskModel> getTasksByReporterId(Long reporterId) {
        User reporter = userRepository.findById(reporterId).orElseThrow(EntityNotFoundException::new);
        Iterable<Task> tasks = taskRepository.findAllByReporter(reporter);
        return StreamSupport.stream(tasks.spliterator(), false)
                .map(taskConverter::entityToModel)
                .collect(Collectors.toList());
    }

    public List<TaskModel> getTasksByExecutorId(Long executorId) {
        User executor = userRepository.findById(executorId).orElseThrow(EntityNotFoundException::new);
        Iterable<Task> tasks = taskRepository.findAllByExecutor(executor);
        return StreamSupport.stream(tasks.spliterator(), false)
                .map(taskConverter::entityToModel)
                .collect(Collectors.toList());
    }

    public List<TaskModel> getTasksByLocation(String location) {
        Iterable<Task> tasks = taskRepository.findAllByLocation(location);
        return StreamSupport.stream(tasks.spliterator(), false)
                .map(taskConverter::entityToModel)
                .collect(Collectors.toList());
    }

    public List<TaskModel> getAllTasksByTypeTitle(String title) {
        TaskType taskType = taskTypeRepository.findByTitle(title);
        Iterable<Task> tasks = taskRepository.findAllByTaskType(taskType);
        return StreamSupport.stream(tasks.spliterator(), false)
                .map(taskConverter::entityToModel)
                .collect(Collectors.toList());
    }

    public List<TaskModel> getTasksByParentTask(Long id) {
        Task parentTask = taskRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        Iterable<Task> tasks = taskRepository.findAllByParentTask(parentTask);
        return StreamSupport.stream(tasks.spliterator(), false)
                .map(taskConverter::entityToModel)
                .collect(Collectors.toList());
    }

    public void createNewTask(TaskModel taskModel) {
        taskRepository.save(taskConverter.modelToEntity(taskModel));
    }

    public void updateTaskById(Long id, TaskModel taskModel) {
        Task task = taskRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        task.setName(taskModel.getName());
        task.setDescription(taskModel.getDescription());
        task.setLocation(taskModel.getLocation());
        task.setComment(taskModel.getComment());
        //task.setTaskType(taskTypeRepository.findById(taskModel.getTaskTypeId()).orElseThrow(EntityNotFoundException::new));
        task.setUpdateDate(LocalDateTime.now());
        taskRepository.save(task);
    }

    public void deleteTaskById(Long id) {
        Task task = taskRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        task.setActive(false);
        taskRepository.save(task);
    }
}
