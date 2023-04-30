package com.code.factory.studentrestapi.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="subject")
@Data
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "credits")
    private Integer credits;

}
