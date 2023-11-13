package com.practice.hibernate.manytomany;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "student_bi")
public class StudentBi {

    @Id
    @GeneratedValue
    private int studentId;

    private String studentName;

    @ManyToMany(mappedBy = "studentList", cascade = CascadeType.ALL)
    List<CourseBi> courseList=new ArrayList<>();

    public void addCourse(CourseBi course){
        courseList.add(course);
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public List<CourseBi> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<CourseBi> courseList) {
        this.courseList = courseList;
    }
}
