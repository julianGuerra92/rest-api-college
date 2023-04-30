package com.code.factory.studentrestapi.dto;

import com.code.factory.studentrestapi.model.Subject;
import lombok.Data;

import java.time.LocalDate;

@Data
public class SubjectsWrapperDto {

    private Integer idStudentSubject;
    private LocalDate registrationDate;
    private Subject subject;

}
