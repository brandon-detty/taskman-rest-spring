package com.brandon_detty.taskman_rest_api.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;

@Entity
public class TaskProgress {
    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Getter
    @Setter
    @ManyToOne
    private Task task;

    @Getter
    @Setter
    @ManyToOne
    private User user;

    @Getter
    @Setter
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false, length = 19)
    private Date created;

    @Getter
    @Setter
    private Integer progressScore;

    @Getter
    @Setter
    private Short type;

    @Getter
    @Setter
    private String memo;
}