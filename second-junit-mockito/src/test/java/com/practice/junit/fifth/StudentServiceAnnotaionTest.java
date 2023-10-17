package com.practice.junit.fifth;

import com.practice.junit.fourth.Student;
import com.practice.junit.fourth.StudentDAO;
import com.practice.junit.fourth.StudentService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class StudentServiceAnnotaionTest {

    @Mock
    private StudentDAO studentDAO;

    @InjectMocks
    private StudentService studentService;

    @Captor
    ArgumentCaptor<Student> studentArgumentCaptor;

    @Test
    void saveStudent() {
        //Use can use below line or annotation @ExtendWith(MockitoExtension.class) on class name.
        // MockitoAnnotations.openMocks(this);
        Student student=new Student();
        student.setId(1l);
        student.setFirstName("John");
        student.setLastName("Doe");
        student.setAge(24);
        Mockito.when(studentDAO.saveStudent(ArgumentMatchers.any())).thenReturn(student);
        studentService.saveStudent(new Student());
    }


    @Test
    void newStudent_nameStartWith_Else(){
        studentService.newStudent("Jane");
        Mockito.verify(studentDAO).saveStudent(studentArgumentCaptor.capture());
        Student student = studentArgumentCaptor.getValue();
        assertEquals("Jane", student.getFirstName());
        assertEquals("jane", student.getLastName());
        assertEquals(18, student.getAge());
        assertEquals(LocalDate.of(2002, 2, 5), student.getDob());

    }
    @Test
    void newStudent_nameStartWith_If(){
        studentService.newStudent("Alice");
        Mockito.verify(studentDAO).saveStudent(studentArgumentCaptor.capture());
        Student student = studentArgumentCaptor.getValue();
        assertEquals("Alice", student.getFirstName());
        assertEquals("ALICE", student.getLastName());
        assertEquals(22, student.getAge());
        assertEquals(LocalDate.now(), student.getDob());

    }
    @Test
    void newStudent(){
        Student student1 = new Student();
        student1.setFirstName("Alice");
        student1.setLastName("ALICE");
        student1.setAge(23);
        student1.setDob(LocalDate.now());
        studentService.newStudent(student1);
        Mockito.verify(studentDAO).saveStudent(studentArgumentCaptor.capture());
        Student student = studentArgumentCaptor.getValue();
        assertEquals("Alice", student.getFirstName());
        assertEquals("ALICE", student.getLastName());
        assertEquals(23, student.getAge());
        assertEquals(LocalDate.now(), student.getDob());

    }

}