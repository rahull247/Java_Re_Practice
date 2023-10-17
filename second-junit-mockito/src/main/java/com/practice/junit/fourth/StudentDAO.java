package com.practice.junit.fourth;

import java.util.List;

public class StudentDAO {

    public List<Student> getAllStudents(){
        System.out.println("StudentDAO : getAllStudents() is called");
        return null;
    }
    public Student getStudentById(Long id){
        System.out.println("StudentDAO : getStudentById() is called");
        return null;
    }

    public Student getStudentByName(String name){
        System.out.println("StudentDAO : getStudentByName() is called");
        return null;
    }
    public Student saveStudent(Student student){
        System.out.println("StudentDAO : saveStudent() is called");
        return null;
    }

    public List<Marks> getMarks(Long Id){
        System.out.println("StudentDAO : getMarks() is called");
        return null;
    }



}
