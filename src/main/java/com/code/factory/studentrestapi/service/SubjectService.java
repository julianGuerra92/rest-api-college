package com.code.factory.studentrestapi.service;

import com.code.factory.studentrestapi.repository.SubjectRepository;
import org.springframework.stereotype.Service;

@Service
public class SubjectService {
    private SubjectRepository subjectRepository;

    public SubjectService(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

}
