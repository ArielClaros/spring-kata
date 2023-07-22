package com.ss.web.app.service;

import com.ss.web.app.model.Subject;
import com.ss.web.app.repository.SubjectRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class SubjectServiceImpl implements SubjectService{

    @Autowired
    private SubjectRepo subjectRepo;

    public SubjectServiceImpl(SubjectRepo subjectRepo){
        this.subjectRepo = subjectRepo;
    }

    @Override
    public Subject addSubject(Subject subject) {
        return subjectRepo.save(subject);
    }

    @Override
    public List<Subject> findAll() {
        return subjectRepo.findAll();
    }

    @Override
    public Subject edit(Subject subject) {
        return subjectRepo.edit(subject);
    }

    @Override
    public boolean delete(Subject subject) {
        return subjectRepo.delete(subject);
    }
}
