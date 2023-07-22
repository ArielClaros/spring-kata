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
        Subject subject = new Subject(4L, "Algoritmia", "");

        when(repo.save(subject)).thenReturn(subject);

        Subject expectedSubject = subjectService.addSubject(subject);

        assertNotNull(expectedSubject);
        assertEquals(subject, expectedSubject);
    }

    @Test
    public void editSubject() {
        SubjectRepo repo = mock(SubjectRepo.class);
        SubjectServiceImpl subjectService = new SubjectServiceImpl(repo);
        Subject existingSubject = new Subject(1L, "Progra", "");
        Subject updatedSubject = new Subject(1L, "New Progra", "Description");

        when(repo.edit(updatedSubject)).thenReturn(updatedSubject);
        Subject editedStudent = subjectService.edit(updatedSubject);

        assertNotNull(editedStudent);
        assertEquals(updatedSubject, editedStudent);
        assertNotEquals(existingSubject, editedStudent);
    }

    @Test
    public void deleteSubject(){
        SubjectRepo repo = mock(SubjectRepo.class);
        SubjectServiceImpl subjectService = new SubjectServiceImpl(repo);
        Subject subjectToDelete = new Subject(2L, "Interaccion", "");

        when(repo.delete(subjectToDelete)).thenReturn(true);
        boolean isDeleted = subjectService.delete(subjectToDelete);

        assertTrue(isDeleted);
    }
}