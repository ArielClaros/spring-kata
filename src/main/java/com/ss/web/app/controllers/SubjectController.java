package com.ss.web.app.controllers;

import com.ss.web.app.model.Subject;
import com.ss.web.app.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subjects")
public class SubjectController {
    @Autowired
    SubjectService subjectService;

    @GetMapping
    public List<Subject> getAll() {
        return subjectService.findAll();
    }

    @PostMapping("/create")
    public Subject createSubject(@RequestBody Subject subject) {
        return subjectService.addSubject(subject);
    }

    @DeleteMapping("/delete")
    public boolean deleteSubject(@RequestBody Subject subject) {
        return subjectService.delete(subject);
    }
}
