package com.code.factory.studentrestapi.controller;

import com.code.factory.studentrestapi.dto.StudentSubjectDto;
import com.code.factory.studentrestapi.dto.StudentWithSubjectsDto;
import com.code.factory.studentrestapi.model.Student;
import com.code.factory.studentrestapi.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/get-student-with-subject/{id}")
    public ResponseEntity<StudentWithSubjectsDto> getStudentWithSubjects(@PathVariable Integer id) {
        var studentSubjects = service.getStudentSubjects(id);
        return ResponseEntity.ok(studentSubjects);
    }

    @PostMapping()
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        var newStudent = service.createStudent(student);
        return ResponseEntity.ok(newStudent);
    }

    @PutMapping("/update-student")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student) {
        var newStudent = service.updateStudent(student);
        return ResponseEntity.ok(newStudent);
    }

    @DeleteMapping()
    public ResponseEntity<String> deleteById(@RequestParam Integer id) {
        service.deleteStudent(id);
        return ResponseEntity.ok("Eliminado correctamente!");
    }


}
