package ru.boost.charity.rest_api.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.boost.charity.rest_api.model.TaskModel;
import ru.boost.charity.rest_api.model.UserModel;
import ru.boost.charity.rest_api.service.UserService;

import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/rest/task")
@RequiredArgsConstructor
public class TaskController {

    @GetMapping
    public ResponseEntity<List<TaskModel>> getAllTasks() {
        return new ResponseEntity<>(List.of(
                new TaskModel(1L, "Имя №1", "Описание №1",
                        "Локация №1", "Коммент №1", 1L, 1L,
                        null, 1L, null, null, LocalDateTime.now(), null, null, true
                ),
                new TaskModel(2L, "Имя №2", "Описание №2",
                        "Локация №2", "Коммент №2", 1L, 1L,
                        null, 1L, null, null, LocalDateTime.now(), null, null, true
                )
        ), HttpStatus.OK);
    }

    @GetMapping("/{status}")
    public ResponseEntity<List<TaskModel>> getAllTasksByStatus(@PathVariable String status) {
        return new ResponseEntity<>(List.of(new TaskModel(
                1L, "Имя №1", status,
                "Локация №1", "Коммент №1", 1L, 1L,
                null, 1L, null, null, LocalDateTime.now(), null, null, true
        )), HttpStatus.OK);
    }
}
