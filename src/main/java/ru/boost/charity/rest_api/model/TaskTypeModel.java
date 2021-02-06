package ru.boost.charity.rest_api.model;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class TaskTypeModel {

    private Long id;

    @NotNull
    private String name;

    @NotNull
    private String title;

    private String description;

    private boolean isActive;
}
