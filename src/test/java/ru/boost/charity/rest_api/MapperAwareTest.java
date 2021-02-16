package ru.boost.charity.rest_api;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.List;

public abstract class MapperAwareTest extends ContextAwareTest {
    @Autowired
    protected ObjectMapper mapper;

    protected <T> T deserialize(String filename, Class<T> type) throws IOException {
        return new TestResourceAsObject<>(
                mapper,
                getClass(),
                filename,
                type
        ).value();
    }

    protected <T> List<T> deserializeArray(String filename, Class<T> type) throws IOException {
        return new TestResourceAsObject<>(
                mapper,
                getClass(),
                filename,
                type
        ).list();
    }
}