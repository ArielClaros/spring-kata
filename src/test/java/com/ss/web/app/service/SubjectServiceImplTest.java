package com.ss.web.app.service;

import com.ss.web.app.model.Subject;
import com.ss.web.app.repository.SubjectRepo;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.*;

public class SubjectServiceImplTest {
    @Test
    public void addSubject() {
        SubjectRepo repo = mock(SubjectRepo.class);
        SubjectServiceImpl subjectService = new SubjectServiceImpl(repo);
        Subject subject = new Subject(1L, "Algoritmia", "");

        when(repo.save(subject)).thenReturn(subject);

        Subject expectedSubject = subjectService.addSubject(subject);

        assertNotNull(expectedSubject);
        assertEquals(subject, expectedSubject);
    }
}
