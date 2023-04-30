package com.code.factory.studentrestapi.service;

import com.code.factory.studentrestapi.dto.StudentWithSubjectsDto;
import com.code.factory.studentrestapi.dto.SubjectsWrapperDto;
import com.code.factory.studentrestapi.model.Student;
import com.code.factory.studentrestapi.model.StudentSubject;
import com.code.factory.studentrestapi.repository.StudentRepository;
import com.code.factory.studentrestapi.repository.StudentSubjectsRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class StudentService {

    private StudentRepository repository;
    private StudentSubjectsService studentSubjectsService;

    public StudentService(StudentRepository repository, StudentSubjectsService studentSubjectsService) {
        this.repository = repository;
        this.studentSubjectsService = studentSubjectsService;
    }

    public StudentWithSubjectsDto getStudentSubjects(Integer idStudent) {
        List<StudentSubject> studentWithSubjects = studentSubjectsService.findSubjectsByIdStudent(idStudent);
        if(studentWithSubjects.isEmpty()) {
            //TODO: puede hacer sus exception handler personalizadas
            throw new RuntimeException("Este estudiante no tiene materias");
        }
        StudentWithSubjectsDto studentWithSubjectsDto = new StudentWithSubjectsDto();
        studentWithSubjectsDto.setIdStudent(idStudent);
        studentWithSubjectsDto.setFullName(studentWithSubjects.get(0).getStudent().getFullName());
        studentWithSubjectsDto.setDocument(studentWithSubjects.get(0).getStudent().getDocument());
        List<SubjectsWrapperDto> subjectsWrapperDtoList = studentWithSubjects.stream().map(studentSubject -> {
            SubjectsWrapperDto subjectsWrapperDto = new SubjectsWrapperDto();
            subjectsWrapperDto.setIdStudentSubject(studentSubject.getId());
            subjectsWrapperDto.setRegistrationDate(studentSubject.getRegistrationDate());
            subjectsWrapperDto.setSubject(studentSubject.getSubject());
            return subjectsWrapperDto;
        }).toList();
        studentWithSubjectsDto.setSubjectList(subjectsWrapperDtoList);
        return studentWithSubjectsDto;
    }

    public List<Student> findAll() {
        var studentList = repository.findAll();
        return studentList;
    }

    public List<Student> findByName(String name) {
        var student = repository.findByFullNameContains(name);
        return student;
    }

    public Student createStudent(Student student) {
        return repository.save(student);
    }

    public Student updateStudent(Student student) {
        var studentTransaction = repository
                .findById(student.getId())
                .orElseThrow(() -> new RuntimeException("El estudante no existe!"));
        studentTransaction.setDocument(student.getDocument());
        studentTransaction.setFullName(student.getFullName());
        return studentTransaction;
    }

    public void deleteStudent(Integer id) {
        if (Objects.nonNull(id)) {
            Optional<Student> studentOptional = repository.findById(id);
            if (!studentOptional.isPresent()) {
                throw new RuntimeException("El estudiante no existe!");
            }
        }
        repository.deleteById(id);
    }

}
