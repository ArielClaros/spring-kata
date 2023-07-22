package com.ss.web.app.service;

import com.ss.web.app.model.Subject;

import java.util.List;

public interface SubjectService {
    Subject addSubject(Subject subject);

    List<Subject> findAll();

    Subject edit(Subject subject);

    boolean delete(Subject subject);
}
