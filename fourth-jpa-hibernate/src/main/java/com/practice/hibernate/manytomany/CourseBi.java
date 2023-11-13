package com.practice.hibernate.manytomany;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "course_bi")
public class CourseBi {

    @Id
    @GeneratedValue
    private int courseId;

    private String courseName;

    @ManyToMany
    @JoinTable(name = "student_course_bi",
            joinColumns = @JoinColumn(name = "course_id"),
            inverseJoinColumns = @JoinColumn(name = "student_id")
    )
    private List<StudentBi> studentList=new ArrayList<>();

    public void addStudent(StudentBi student){
        studentList.add(student);
    }
    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public List<StudentBi> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<StudentBi> studentList) {
        this.studentList = studentList;
    }
}
