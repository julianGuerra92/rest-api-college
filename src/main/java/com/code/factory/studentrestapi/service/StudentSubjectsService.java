package com.code.factory.studentrestapi.service;

import com.code.factory.studentrestapi.model.StudentSubject;
import com.code.factory.studentrestapi.repository.StudentSubjectsRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class StudentSubjectsService {

    private StudentSubjectsRepository studentSubjectsRepository;

    public StudentSubjectsService(StudentSubjectsRepository studentSubjectsRepository) {
        this.studentSubjectsRepository = studentSubjectsRepository;
    }

    public List<StudentSubject> findSubjectsByIdStudent(Integer idStudent) {
        var studentSubjects = studentSubjectsRepository.findSubjects(idStudent);
        return studentSubjects;
    }

}
