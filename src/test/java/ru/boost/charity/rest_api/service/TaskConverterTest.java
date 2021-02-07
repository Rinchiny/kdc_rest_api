package ru.boost.charity.rest_api.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ru.boost.charity.rest_api.MapperAwareTest;
import ru.boost.charity.rest_api.entity.Task;
import ru.boost.charity.rest_api.model.TaskModel;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

class TaskConverterTest extends MapperAwareTest {

    @Autowired
    TaskConverter taskConverter;

    @Test
    void entityToModel() throws IOException {
        assertThat(
                taskConverter.entityToModel(
                        deserialize("task", Task.class)))
                .isEqualTo(
                        deserialize("taskModel", TaskModel.class));
    }
}