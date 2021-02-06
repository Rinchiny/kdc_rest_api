package ru.boost.charity.rest_api.model;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
public class TaskModel {

    private Long id;

    @NotNull
    private String name;

    @NotNull
    private String description;

    private String location;

    private String comment;

    @NotNull
    private Long taskTypeId;

    private Long taskStatusId;

    private Long parentTaskId;

    @NotNull
    private Long reporterId;

    private Long moderatorId;

    private Long executorId;

    private Date createDate;

    private Date updateDate;

    private Date expirationDate;

    private boolean isActive;
}
