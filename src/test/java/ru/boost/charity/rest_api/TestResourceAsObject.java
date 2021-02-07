package ru.boost.charity.rest_api;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.util.List;

public final class TestResourceAsObject<T> {
    private final ObjectMapper mapper;
    private final Resource resource;
    private final Class<T> type;

    public <P> TestResourceAsObject(ObjectMapper mapper, Class<P> clazz, String filename, Class<T> type) {
        this(
                mapper,
                new ClassPathResource(
                        new JsonFileLocation(clazz, filename).asText()
                ),
                type
        );
    }

    public TestResourceAsObject(ObjectMapper mapper, String fullPath, Class<T> type) {
        this(
                mapper,
                new ClassPathResource(
                        new JsonFileLocation(fullPath).asText()
                ),
                type
        );
    }

    public TestResourceAsObject(ObjectMapper mapper, Resource resource, Class<T> type) {
        this.mapper = mapper;
        this.resource = resource;
        this.type = type;
    }

    public T value() throws IOException {
        return mapper.readValue(resource.getFile(), type);
    }

    public List<T> list() throws IOException {
        return mapper.readValue(
                resource.getFile(),
                mapper.getTypeFactory().constructCollectionType(List.class, type)
        );
    }
}
