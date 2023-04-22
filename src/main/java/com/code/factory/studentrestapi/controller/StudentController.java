package com.code.factory.studentrestapi.controller;

import com.code.factory.studentrestapi.model.Student;
import com.code.factory.studentrestapi.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    private StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    @GetMapping("/find-all")
    public ResponseEntity<List<Student>> findAll() {
        var studentList = service.findAll();
        return ResponseEntity.ok(studentList);
    }

    @GetMapping("/find-by-name")
    public ResponseEntity<List<Student>> findByName(@RequestParam String name) {
        var studentList = service.findByName(name);
        return ResponseEntity.ok(studentList);
    }

}
