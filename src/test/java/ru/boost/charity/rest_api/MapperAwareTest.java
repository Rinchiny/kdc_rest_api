package ru.boost.charity.rest_api;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.io.IOException;
import java.util.List;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public abstract class MapperAwareTest {
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
