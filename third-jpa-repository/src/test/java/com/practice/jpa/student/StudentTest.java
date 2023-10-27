package com.practice.jpa.student;

import com.practice.jpa.model.Student;
import com.practice.jpa.repository.StudentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Comparator;
import java.util.List;
import java.util.OptionalDouble;
import java.util.OptionalInt;


@SpringBootTest
public class StudentTest {
/*Exercise 1:
             Create student model class : id, name & marks(generate getter, setter & toString()).
             Create student repository with extends JpaRepository.
             Create student test class and get: min, max, average & student object.
*/
        @Autowired
        private StudentRepository studentRepository;

        @BeforeEach()
        void setup(){
            Student jimmy=new Student(1, "Jimmy", 80);
            Student james=new Student(2, "James", 70);
            Student andrew=new Student(3, "Andrew", 64);
            studentRepository.save(jimmy);
            studentRepository.save(james);
            studentRepository.save(andrew);
        }


        @Test
    void studentWithMinimumMarks(){
            List<Student> allStudent = studentRepository.findAll();
            OptionalInt min = allStudent.stream().mapToInt(Student::getMarks).min();
            System.out.println("------------------------");
            System.out.println("Minimum Marks::"+min);
        }
        @Test
    void studentWithMaximumMarks(){
            List<Student> allStudent = studentRepository.findAll();
            OptionalInt max = allStudent.stream().mapToInt(Student::getMarks).max();
            System.out.println("------------------------");
            System.out.println("Maximum Marks::"+max);
        }
        @Test
    void studentWithAverageMarks(){
            List<Student> allStudent = studentRepository.findAll();
            OptionalDouble average = allStudent.stream().mapToInt(Student::getMarks).average();
            System.out.println("------------------------");
            System.out.println("Average Marks::"+average);
        }
        @Test
    void studentWithHighestMarksObject(){
            List<Student> allStudent = studentRepository.findAll();
            Student student = allStudent.stream().max(Comparator.comparing(Student::getMarks)).get();
            System.out.println("------------------------");
            System.out.println("Highest Marks Student::"+student);
        }

}
