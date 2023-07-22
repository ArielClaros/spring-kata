package com.ss.web.app.repository;

import com.ss.web.app.model.Subject;

import java.util.List;

public interface SubjectRepo {
    Subject save(Subject subject);

    List<Subject> findAll();

    Subject edit(Subject subject);

    boolean delete(Subject subject);
}
