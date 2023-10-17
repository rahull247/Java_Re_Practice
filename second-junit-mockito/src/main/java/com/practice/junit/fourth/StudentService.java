package com.practice.junit.fourth;

import java.time.LocalDate;

public class StudentService {
    private final StudentDAO studentDAO;

    private static int count=0;

    public StudentService(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    public boolean isValid(Long id) {
        System.out.println("isValid() method received id" + id);
        return null != id;
    }

    public Student saveStudent(Student student) {
        Student newStudent = studentDAO.saveStudent(student);
        System.out.println("newStudent: " + newStudent);
        Student fetchStudentById = studentDAO.getStudentById(newStudent.getId());
        System.out.println("fetchStudentById: " + fetchStudentById);
        if (newStudent == null || newStudent.getId() == null) {
            throw new RuntimeException("Student could not be saved");
        }
        return newStudent;
    }

    public void newStudent(String name) {
        Student student = new Student();
        if (name.startsWith("a") || name.startsWith("A")) {
            student.setFirstName(name);
            student.setLastName(name.toUpperCase());
            student.setAge(22);
            student.setDob(LocalDate.now());
        } else {
            student.setFirstName(name);
            student.setLastName(name.toLowerCase());
            student.setAge(18);
            student.setDob(LocalDate.of(2002, 2, 5));
        }

        studentDAO.saveStudent(student);
        System.out.println("newStudent(): Student :" + student);
    }

    public void newStudent(Student student) {
        Student student1 = new Student();
        student1.setFirstName(student.getFirstName());
        student1.setLastName(student.getLastName());
        student1.setAge(student.getAge());
        student1.setDob(student.getDob());
        studentDAO.saveStudent(student1);
        System.out.println("newStudent(): Student1 :" + student1);
    }

    public void increment(){
        System.out.println(count++);
    }
}
