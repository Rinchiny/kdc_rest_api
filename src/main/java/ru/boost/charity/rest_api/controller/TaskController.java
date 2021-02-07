package ru.boost.charity.rest_api.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.boost.charity.rest_api.model.TaskModel;
import ru.boost.charity.rest_api.service.TaskService;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/rest/task")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @GetMapping("/")
    public ResponseEntity<List<TaskModel>> getAllTasks() {
        return new ResponseEntity<>(taskService.getAllTasks(), HttpStatus.OK);
    }

    @GetMapping("/status/{title}")
    public ResponseEntity<List<TaskModel>> getAllTasksByStatus(@PathVariable String title) {
        return new ResponseEntity<>(taskService.getAllTasksByStatusTitle(title), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskModel> getTaskById(@PathVariable Long id) {
        return new ResponseEntity<>(taskService.getTaskById(id), HttpStatus.OK);
    }

    @GetMapping("/reporter/{id}")
    public ResponseEntity<List<TaskModel>> getTasksByReporterId(@PathVariable Long id) {
        return new ResponseEntity<>(taskService.getTasksByReporterId(id), HttpStatus.OK);
    }

    @GetMapping("/executor/{id}")
    public ResponseEntity<List<TaskModel>> getTasksByExecutorId(@PathVariable Long id) {
        return new ResponseEntity<>(taskService.getTasksByExecutorId(id), HttpStatus.OK);
    }

    @GetMapping("/location/{location}")
    public ResponseEntity<List<TaskModel>> getTasksByLocation(@PathVariable String location) {
        return new ResponseEntity<>(taskService.getTasksByLocation(location), HttpStatus.OK);
    }

    @GetMapping("/type/{title}")
    public ResponseEntity<List<TaskModel>> getTasksByTypeTitle(@PathVariable String title) {
        return new ResponseEntity<>(taskService.getAllTasksByTypeTitle(title), HttpStatus.OK);
    }

    @GetMapping("/parentTask/{id}")
    public ResponseEntity<List<TaskModel>> getTasksByParentTask(@PathVariable Long id) {
        return new ResponseEntity<>(taskService.getTasksByParentTask(id), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<Void> createTask(@RequestBody TaskModel taskModel) {
        taskService.createNewTask(taskModel);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateTaskById(@PathVariable("id") Long taskId, @RequestBody TaskModel taskModel) {
        taskService.updateTaskById(taskId, taskModel);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable("id") Long taskId) {
        taskService.deleteTaskById(taskId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
