package ru.boost.charity.rest_api.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@Entity
public class UploadedFile {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @NotNull
    private Long taskId;

    @NotNull
    private Long userId;

    @NotNull
    private byte[] value;

    @NotNull
    private Date createDate;

    private Date updateDate;

    @NotNull
    private boolean isActive;

    @PrePersist
    void createdAt() {
        this.createDate = new Date();
    }
}