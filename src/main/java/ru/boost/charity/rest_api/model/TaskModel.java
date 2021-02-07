package ru.boost.charity.rest_api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
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

    private LocalDateTime createDate;

    private LocalDateTime updateDate;

    private LocalDateTime expirationDate;

    private boolean isActive;
}
