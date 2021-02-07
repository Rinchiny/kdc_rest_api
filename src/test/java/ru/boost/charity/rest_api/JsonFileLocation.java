package ru.boost.charity.rest_api;

public final class JsonFileLocation {
    private final String location;

    public JsonFileLocation(Class<?> clazz, String filename) {
        this(
                String.format(
                        "%s/%s.json",
                        clazz.getName().replace('.', '/'),
                        filename
                )
        );
    }

    public JsonFileLocation(final String location) {
        this.location = location;
    }

    public String asText() {
        return location;
    }
}