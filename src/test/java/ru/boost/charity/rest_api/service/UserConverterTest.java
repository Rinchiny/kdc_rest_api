package ru.boost.charity.rest_api.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ru.boost.charity.rest_api.MapperAwareTest;
import ru.boost.charity.rest_api.entity.Task;
import ru.boost.charity.rest_api.entity.User;
import ru.boost.charity.rest_api.model.TaskModel;
import ru.boost.charity.rest_api.model.UserModel;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class UserConverterTest extends MapperAwareTest {

    @Autowired
    UserConverter userConverter;

    @Test
    void entityToModel() throws IOException {
        assertThat(
                userConverter.entityToModel(
                        deserialize("task", User.class)
                )).isEqualTo(
                deserialize("taskModel", UserModel.class)
        );
    }

    @Test
    void modelToEntity() {
    }
}