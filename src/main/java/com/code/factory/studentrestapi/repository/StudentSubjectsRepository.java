package com.code.factory.studentrestapi.repository;

import com.code.factory.studentrestapi.model.StudentSubject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentSubjectsRepository extends JpaRepository<StudentSubject, Integer> {

    @Query("SELECT s FROM StudentSubject s WHERE s.idStudent = :idStudent")
    List<StudentSubject> findSubjects(@Param("idStudent") Integer idStudent);

}
