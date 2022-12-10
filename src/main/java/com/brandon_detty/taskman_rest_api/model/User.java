package com.brandon_detty.taskman_rest_api.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.UniqueConstraint;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(uniqueConstraints = {
        @UniqueConstraint(columnNames = "email"),
        @UniqueConstraint(columnNames = "username")
})
public class User {
    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Getter
    @Setter
    @Column(length = 30)
    private String username;

    @Getter
    @Setter
    @Column(length = 45)
    private String email;

    @Getter
    @Setter
    @Column(length = 40)
    private String firstName;

    @Getter
    @Setter
    @Column(length = 40)
    private String lastName;

    @Getter
    @Setter
    @Column(length = 32)
    private String salt;

    @Getter
    @Setter
    @Column(length = 64)
    private String passwordHash;

    @Getter
    @Setter
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false, length = 19)
    private Date created;
}