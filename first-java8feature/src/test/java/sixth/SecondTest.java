package sixth;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.Stream;

/*Exercise: 6
A new class(Student) with name, age, marksMath, marksScience

Generate following reports:
1)Display name of all students in Alphabetical order
2)Display name of Student who got highest in math(use Comparator inside max)
3)Display name of Student who got highest in science(use Comparator inside max)
4)Display name of Student who got highest overall(use Comparator inside max)
5)Display name of youngest student
6)Display name of eldest student
7)Display the highest marks in math
8)Display the highest marks in science
*/
public class SecondTest {

    @Test
    void first_sortedNames(){
        Stream<Student> studentStream = Stream.of(
                new Student("Rahul", 21, 81, 99),
                new Student("Akshay", 27, 95, 81),
                new Student("Simon", 25, 73, 77),
                new Student("Kunal", 23, 50, 100)
        );

        Stream<String> sorted = studentStream.map(Student::getName).sorted();
        sorted.forEach(System.out::println);
    }

    @Test
    void second_displayNamesOfStudentHighestInMaths() {
        Stream<Student> studentStream = Stream.of(
                new Student("Rahul", 21, 81, 99),
                new Student("Akshay", 27, 95, 81),
                new Student("Simon", 25, 73, 77),
                new Student("Kunal", 23, 50, 100)
        );

        Optional<String> s = studentStream.max(Comparator.comparing(Student::getMarksMaths)).map(Student::getName);
        System.out.println("Student name highest marks in math: " + s.get());
    }
    @Test
    void third_displayNamesOfStudentHighestInScience() {
        Stream<Student> studentStream = Stream.of(
                new Student("Rahul", 21, 81, 99),
                new Student("Akshay", 27, 95, 81),
                new Student("Simon", 25, 73, 77),
                new Student("Kunal", 23, 50, 100)
        );

        Optional<String> s = studentStream.max(Comparator.comparing(Student::getMarksScience)).map(Student::getName);
        System.out.println("Student name highest marks in science: " + s.get());
    }
    @Test
    void fourth_displayNamesOfStudentHighestInOverall() {
        Stream<Student> studentStream = Stream.of(
                new Student("Rahul", 21, 81, 99),
                new Student("Akshay", 27, 95, 81),
                new Student("Simon", 25, 73, 77),
                new Student("Kunal", 23, 50, 100)
        );

        Optional<Student> max = studentStream.max(Comparator.comparing(student -> student.getMarksMaths() + student.getMarksScience()));
        System.out.println("Student name highest marks in overall: " + max.get().getName());
    }
    @Test
    void fifth_displayNamesOfYoungestStudent() {
        Stream<Student> studentStream = Stream.of(
                new Student("Rahul", 21, 81, 99),
                new Student("Akshay", 27, 95, 81),
                new Student("Simon", 25, 73, 77),
                new Student("Kunal", 23, 50, 100)
        );

        Optional<String> s = studentStream.min(Comparator.comparing(student -> student.getAge())).map(Student::getName);
        System.out.println("Youngest student: " + s.get());
    }


    @Test
    void sixth_displayNamesOfEldestStudent() {
        Stream<Student> studentStream = Stream.of(
                new Student("Rahul", 21, 81, 99),
                new Student("Akshay", 27, 95, 81),
                new Student("Simon", 25, 73, 77),
                new Student("Kunal", 23, 50, 100)
        );

        Optional<String> s = studentStream.max(Comparator.comparing(student -> student.getAge())).map(Student::getName);
        System.out.println("Eldest student: " + s.get());
    }
    @Test
    void seven_displayHighestMarksInMath() {
        Stream<Student> studentStream = Stream.of(
                new Student("Rahul", 21, 81, 99),
                new Student("Akshay", 27, 95, 81),
                new Student("Simon", 25, 73, 77),
                new Student("Kunal", 23, 50, 100)
        );

        OptionalInt max = studentStream.mapToInt(Student::getMarksMaths).max();
        System.out.println("Highest marks in math: " + max.getAsInt());
    }

    @Test
    void eight_displayHighestMarksInScience() {
        Stream<Student> studentStream = Stream.of(
                new Student("Rahul", 21, 81, 99),
                new Student("Akshay", 27, 95, 81),
                new Student("Simon", 25, 73, 77),
                new Student("Kunal", 23, 50, 100)
        );

        OptionalInt max = studentStream.mapToInt(Student::getMarksScience).max();
        System.out.println("Highest marks in science: " + max.getAsInt());
    }
}
