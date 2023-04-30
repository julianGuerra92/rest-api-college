package com.code.factory.studentrestapi.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class StudentSubjectDto {

    private Integer id;
    private Integer idStudent;
    private Integer idSubject;
    private LocalDate registrationDate;

}
