package com.code.factory.studentrestapi.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "student_subject")
@Data
public class StudentSubject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "id_student")
    private Integer idStudent;

    @Column(name = "id_subject")
    private Integer idSubject;

    @Column(name = "registration_date")
    private LocalDate registrationDate;

    /*
     * Significa que Un Student puede tener muchas materias (Many subjects To One student)
     */

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_student", insertable = false, updatable = false, nullable = false)
    private Student student;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_subject", insertable = false, updatable = false, nullable = false)
    private Subject subject;

}
