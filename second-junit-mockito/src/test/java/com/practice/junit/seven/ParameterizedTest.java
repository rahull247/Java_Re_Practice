package com.practice.junit.seven;

import com.practice.junit.fourth.Student;
import com.practice.junit.third.Calculator;
import com.practice.junit.third.MyClass;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class ParameterizedTest {


    @org.junit.jupiter.params.ParameterizedTest(name = "{index} of Integer")
    @ValueSource(ints = {1, 2, 3})
    void runInt(int numbers) {
        System.out.println("running test: " + numbers);
    }

    @org.junit.jupiter.params.ParameterizedTest(name = "{index} of Strings")
    @ValueSource(strings = {"one", "two", "three"})
    void runString(String numbers) {
        System.out.println("running test: " + numbers);
    }

    @org.junit.jupiter.params.ParameterizedTest
    @EnumSource(Color.class)
    void runEnum(Color color) {
        System.out.println("Color is: " + color);
    }

    @org.junit.jupiter.params.ParameterizedTest
    @EnumSource(value = Color.class, names = {"WHITE", "PISTA"})
    void runEnumInclude(Color color) {
        System.out.println("Color is: " + color);
    }

    @org.junit.jupiter.params.ParameterizedTest
    @EnumSource(value = Color.class, names = {"WHITE", "PISTA"}, mode = EnumSource.Mode.EXCLUDE)
    void runEnumExclude(Color color) {
        System.out.println("Color is: " + color);
    }

    @Disabled
    @org.junit.jupiter.params.ParameterizedTest
    @CsvSource(value = {"2, 3", "3, 4"})
    void runCsvInt(int num1, int num2) {
        System.out.println("num1= " + num1 + " num2= " + num2);
        Calculator calculator = new Calculator(new MyClass());
        //int result = calculator.add(num1, num2);
        int result = 0;
        int expectedResult = num1 + num2 + 4;
        Assertions.assertEquals(expectedResult, result);
    }

    @Disabled
    @org.junit.jupiter.params.ParameterizedTest
    @CsvSource(value = {"one, two", "three, four"})
    void runCsvString(String str1, String str2) {
        System.out.println("str1= " + str1 + " str2= " + str2);
    }

    @Disabled
    @org.junit.jupiter.params.ParameterizedTest
    @CsvSource(value = {"1, two", "3, four"})
    void runCsvString(int num1, String str2) {
        System.out.println("num1= " + num1 + " str2= " + str2);
    }

    @org.junit.jupiter.params.ParameterizedTest
    @MethodSource("StringProvideList")
    void runStringMethodSource(String str) {
        System.out.println(str);
    }

    static List<String> StringProvideList() {
        return Arrays.asList("Hello", "World", "of", "String");
    }

    @org.junit.jupiter.params.ParameterizedTest
    @MethodSource("StringProvideStream")
    void runStreamMethodSource(String str) {
        System.out.println(str);
    }

    static Stream<String> StringProvideStream() {
        return Stream.of("Hello", "World", "of", "String");
    }

    @org.junit.jupiter.params.ParameterizedTest
    @MethodSource("StringProvideStudent")
    void runStudentMethodSource(Student student) {
        System.out.println(student);
    }

    static List<Student> StringProvideStudent() {
        Student john = new Student();
        john.setId(1l);
        john.setFirstName("John");
        john.setLastName("Doe");
        john.setAge(24);
        john.setDob(LocalDate.now());

        Student july = new Student();
        july.setId(1l);
        july.setFirstName("July");
        july.setLastName("Doe");
        july.setAge(26);
        july.setDob(LocalDate.of(2012, 12, 13));
        return Arrays.asList(john, july);
    }

    @org.junit.jupiter.params.ParameterizedTest
    @MethodSource("StudentProvideStream")
    void runStudentMethodSourceStream(Student student) {
        System.out.println(student);
    }

    static Stream<Student> StudentProvideStream() {
        Student john = new Student();
        john.setId(1l);
        john.setFirstName("John");
        john.setLastName("Doe");
        john.setAge(24);
        john.setDob(LocalDate.now());

        Student july = new Student();
        july.setId(1l);
        july.setFirstName("July");
        july.setLastName("Doe");
        july.setAge(26);
        july.setDob(LocalDate.of(2012, 12, 13));
        return Stream.of(john, july);
    }


    @Test
    @Disabled("This method is disabled")
    void methodDisable(){
        System.out.println("Printing statement...");
    }
}
