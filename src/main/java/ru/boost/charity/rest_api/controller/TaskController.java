package ru.boost.charity.rest_api.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.boost.charity.rest_api.model.TaskModel;
import ru.boost.charity.rest_api.service.TaskService;

import java.util.List;

@Controller
@RequestMapping("/rest/task")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @GetMapping
    public ResponseEntity<List<TaskModel>> getAllTasks() {
        return new ResponseEntity<>(taskService.getAllTasks(), HttpStatus.OK);

    }

    @GetMapping("/{title}")
    public ResponseEntity<List<TaskModel>> getAllTasksByTitle(@PathVariable String title) {
        return new ResponseEntity<>(taskService.getAllTasksByTitle(title), HttpStatus.OK);
    }
}
