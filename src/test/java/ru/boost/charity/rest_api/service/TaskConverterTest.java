package ru.boost.charity.rest_api.service;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ru.boost.charity.rest_api.MapperAwareTest;
import ru.boost.charity.rest_api.entity.Task;
import ru.boost.charity.rest_api.entity.User;
import ru.boost.charity.rest_api.model.TaskModel;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

class TaskConverterTest extends MapperAwareTest {

    @Autowired
    TaskConverter converter;

    @Test
    void entityToModel() throws IOException {
        assertThat(
                converter.entityToModel(
                        deserialize("task", Task.class)
                )
        ).isEqualTo(
                deserialize("taskModel", TaskModel.class)
        );
    }

    @Test
    void modelToEntity() throws IOException {
        assertThat(
                converter.modelToEntity(
                        deserialize("taskModel", TaskModel.class)
                )
        ).isEqualTo(
                updateTask(deserialize("task", Task.class))
        );
    }

    private Task updateTask(Task task) {
        task.setParentTask(new Task());
        task.setModerator(new User());
        task.setExecutor(new User());
        return task;
    }
}