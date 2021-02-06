package ru.boost.charity.rest_api.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@Entity
public class Task {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @NotNull
    private String name;

    private String location;

    private String comment;

    @NotNull
    private Long taskTypeId;

    @NotNull
    private Long taskStatusId;

    @NotNull
    private Long parentTaskId;

    @NotNull
    private Long reporterId;

    private Long moderatorId;

    private Long executorId;

    @NotNull
    private Date createDate;

    private Date updateDate;

    private Date expirationDate;

    @NotNull
    private boolean isActive;

    @PrePersist
    void createdAt() {
        this.createDate = new Date();
    }
}