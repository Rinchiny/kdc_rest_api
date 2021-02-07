package ru.boost.charity.rest_api.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.boost.charity.rest_api.model.TaskModel;
import ru.boost.charity.rest_api.service.TaskService;

import java.util.List;

@Slf4j
@Controller
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
    public ResponseEntity<TaskModel> getTaskById(@PathVariable Long taskId) {
        return new ResponseEntity<>(taskService.getTaskById(taskId), HttpStatus.OK);
    }

    @GetMapping("/{reporterId")
    public ResponseEntity<List<TaskModel>> getTasksByReporterId(@PathVariable Long reporterId) {
        return new ResponseEntity<>(taskService.getTasksByReporterId(reporterId), HttpStatus.OK);
    }
}
