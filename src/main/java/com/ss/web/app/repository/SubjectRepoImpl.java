package com.ss.web.app.repository;

import com.ss.web.app.model.Subject;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class SubjectRepoImpl implements SubjectRepo{
    private List<Subject> subjectList;

    public SubjectRepoImpl(){
        subjectList = new ArrayList<>();
        subjectList.add(new Subject(1L, "Progra", ""));
        subjectList.add(new Subject(2L, "Interaccion", ""));
        subjectList.add(new Subject(3L, "Algebra", ""));
    }

    @Override
    public Subject save(Subject subject) {
        subjectList.add(subject);
        return subject;
    }

    @Override
    public List<Subject> findAll() {
        return subjectList;
    }

    @Override
    public Subject edit(Subject subject) {
        subjectList = subjectList.stream()
                .filter(su -> !su.getCode().equals(subject.getCode()))
                .collect(Collectors.toList());
        subjectList.add(subject);
        return subject;
    }

    @Override
    public boolean delete(Subject subject) {
        return subjectList.remove(subject);
    }
}
