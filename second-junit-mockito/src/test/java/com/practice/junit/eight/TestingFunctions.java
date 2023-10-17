package com.practice.junit.eight;

import com.practice.junit.fourth.Student;
import com.practice.junit.fourth.StudentDAO;
import com.practice.junit.fourth.StudentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestingFunctions {
    private static StudentService studentService;

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
    //Assert All

    @Test
    void saveStudent_withAssertionAll(){
        System.out.println("Test: saveStudent");
        Student student=studentService.saveStudent(new Student());

        assertAll("student",
                () -> assertEquals(1, student.getId()),
                () -> assertEquals("John", student.getFirstName()),
                () -> assertEquals("Doe", student.getLastName()),
                () -> assertEquals(24, student.getAge())
        );
        System.out.println("Test: end saveStudent");
    }
}
