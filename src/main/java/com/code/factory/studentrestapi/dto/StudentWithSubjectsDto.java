package com.code.factory.studentrestapi.dto;

import lombok.Data;

import java.util.List;

@Data
public class StudentWithSubjectsDto {

    private Integer idStudent;
    private String document;
    private String fullName;
    private List<SubjectsWrapperDto> subjectList;

}
