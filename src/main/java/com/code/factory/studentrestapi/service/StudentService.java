package com.code.factory.studentrestapi.service;

import com.code.factory.studentrestapi.model.Student;
import com.code.factory.studentrestapi.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private StudentRepository repository;

    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    public List<Student> findAll() {
        var studentList = repository.findAll();
        return studentList;
    }

    public List<Student> findByName(String name) {
        var student = repository.findByFullNameContains(name);
        return student;
    }

}
