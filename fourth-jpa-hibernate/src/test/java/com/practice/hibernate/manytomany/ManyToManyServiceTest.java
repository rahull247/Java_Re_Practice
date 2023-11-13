package com.practice.hibernate.manytomany;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ManyToManyServiceTest {

    @Autowired
    private ManyToManyService manyToManyService;

    @Test
    void saveManyToMany() {
        StudentBi jason=new StudentBi();
        jason.setStudentName("Jason");

        CourseBi al=new CourseBi();
        al.setCourseName("ArtificialLanguage");
        al.addStudent(jason);

        CourseBi ml=new CourseBi();
        ml.setCourseName("MachineLanguage");
        ml.addStudent(jason);

        jason.addCourse(al);
        jason.addCourse(ml);

        manyToManyService.saveManyToMany(jason);
    }
}