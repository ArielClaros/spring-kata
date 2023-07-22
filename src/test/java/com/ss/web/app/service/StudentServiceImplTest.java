package com.ss.web.app.service;

import com.ss.web.app.model.Student;
import com.ss.web.app.repository.StudentRepo;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.*;

class StudentServiceImplTest {

  @Test
  public void addStudent() {
    StudentRepo repo = mock(StudentRepo.class);
    StudentServiceImpl studentServiceImpl = new StudentServiceImpl(repo);
    Student student = new Student(4L, "ana", "perez");

    when(repo.save(student)).thenReturn(student);
    Student studentExpected = studentServiceImpl.addStudent(student);

    assertNotNull(studentExpected);
    assertEquals(student, studentExpected);
  }

  @Test
  public void editStudent() {
    StudentRepo repo = mock(StudentRepo.class);
    StudentServiceImpl studentServiceImpl = new StudentServiceImpl(repo);
    Student existingStudent = new Student(1L, "Sho", "Test");
    Student updatedStudent = new Student(1L, "Yo", "Student");

    when(repo.edit(updatedStudent)).thenReturn(updatedStudent);
    Student editedStudent = studentServiceImpl.edit(updatedStudent);

    assertNotNull(editedStudent);
    assertEquals(updatedStudent, editedStudent);
    assertNotEquals(existingStudent, editedStudent);
  }

  @Test
  public void deleteStudent() {
    StudentRepo repo = mock(StudentRepo.class);
    StudentServiceImpl studentServiceImpl = new StudentServiceImpl(repo);
    Student studentToDelete = new Student(3L, "Curl", "Test");

    when(repo.delete(studentToDelete)).thenReturn(true);
    boolean isDeleted = studentServiceImpl.delete(studentToDelete);

    assertTrue(isDeleted);
  }
}