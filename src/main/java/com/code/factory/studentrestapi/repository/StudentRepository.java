package com.code.factory.studentrestapi.repository;


import com.code.factory.studentrestapi.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

    List<Student> findByFullNameContains(String name);

}
