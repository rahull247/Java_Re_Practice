package com.practice.junit.sixth;

import com.practice.junit.fourth.StudentDAO;
import com.practice.junit.fourth.StudentService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class JunitAnnotations {

    @Mock
    private StudentDAO studentDAO;

    @InjectMocks
    private StudentService studentService;

    @DisplayName("Title of method") //Instead of method name it will show display name.
    @Test
    void executeMethod() {
        System.out.println("Method is executing");
    }

    @RepeatedTest(2) // This will repeat test upon first test.
    @Test
    void executeMethod1() {
        System.out.println("Method is executing");
    }

    @RepeatedTest(2)
    @Test
    void executeMethod2(RepetitionInfo repetitionInfo) {
        System.out.println("RepetitionInfo : " + repetitionInfo.getCurrentRepetition() + "/" + repetitionInfo.getTotalRepetitions());
        System.out.println("Method is executing");
    }

    @RepeatedTest(value = 2, name = "{currentRepetition}")
    @Test
    void executeMethod3() {
        System.out.println("Method is executing");
    }
    @RepeatedTest(value = 2, name = "[{currentRepetition}] / [{totalRepetitions}]")
    @Test
    void executeMethod4() {
        System.out.println("Method is executing");
    }
    @RepeatedTest(value = 2, name = "[{currentRepetition}] / [{totalRepetitions}]")
    @Test
    void executeMethod5() {
        System.out.println("Method is executing");
        studentService.increment();
    }
}
