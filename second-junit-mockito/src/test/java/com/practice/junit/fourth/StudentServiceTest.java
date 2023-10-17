package com.practice.junit.fourth;

import org.junit.jupiter.api.*;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class StudentServiceTest {

    private static StudentService studentService;

    @BeforeAll
    static void setup(){
        System.out.println("Before All");
    }

    @BeforeEach
    void beforeEach(){
        System.out.println("Before Each");
        StudentDAO mock = Mockito.mock(StudentDAO.class);
        Student student=new Student();
        student.setId(1l);
        student.setFirstName("John");
        student.setLastName("Doe");
        student.setAge(24);
        Mockito.when(mock.saveStudent(ArgumentMatchers.any())).thenReturn(student);
        studentService=new StudentService(mock);
    }

    @AfterEach
    void afterEach(){
        System.out.println("After Each");
    }

    @AfterAll
    static void afterAll(){
        System.out.println("After all");
    }

    public StudentServiceTest() {
        System.out.println("Constructor");
    }

    @Test
    void isValid() {
        System.out.println("isValid()");
    }

    @Test
    void saveStudent() {
        System.out.println("saveStudent()");
        studentService.saveStudent(new Student());
    }

    @Test
    void saveStudentWithSpyInsteadOfMock(){
        System.out.println("saveStudentWithSpyInsteadOfMock");
        StudentDAO spy = Mockito.spy(StudentDAO.class);
        Student student=new Student();
        student.setId(1l);
        student.setFirstName("John");
        student.setLastName("Doe");
        student.setAge(24);
        Mockito.when(spy.saveStudent(ArgumentMatchers.any())).thenReturn(student);
        Mockito.when(spy.getStudentById(ArgumentMatchers.anyLong())).thenReturn(student);
        studentService=new StudentService(spy);
        studentService.saveStudent(new Student());
        System.out.println("saveStudentWithSpyInsteadOfMock ends");
    }
}