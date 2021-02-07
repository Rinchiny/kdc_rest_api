package ru.boost.charity.rest_api.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@Entity
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @NotNull
    private String email;

    @NotNull
    private String password;

    private byte[] avatar;

    @NotNull
    private Long roleId;

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
