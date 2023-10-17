package com.practice.junit.third;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {

    private MyClass mock;

    @BeforeEach // this @BeforeEach annotation is used on method which need to be run before each @Test annotation methods.
    void beforeMethod(){
        mock = Mockito.mock(MyClass.class);
        Mockito.when(mock.getDBConnection(Mockito.anyString())).thenReturn("Hi");
    }

    @Test
    void first_manipulateData_noDataFound(){
        // Mockito.mock(javaFileName.class) is used when we don't want to make network call(another microservice or database).
        MyClass mock = Mockito.mock(MyClass.class);
        Calculator calculator=new Calculator(mock);
        String s = calculator.manipulateData();
        assertEquals("No data found!", s);
    }
    @Test
    void second_manipulateData_GreaterThanSize2Data(){
        MyClass mock = Mockito.mock(MyClass.class);
        //Mockito.when(mockObject.method()).thenReturn(something) is used when this methods call something should return.
        Mockito.when(mock.getDBConnection()).thenReturn("Hi World!");
        Calculator calculator=new Calculator(mock);
        String s = calculator.manipulateData();
        assertEquals("Greater than 2 data found", s);
    }
    @Test
    void third_manipulateData_normalDataFound(){
        MyClass mock = Mockito.mock(MyClass.class);
        Mockito.when(mock.getDBConnection()).thenReturn("Hi");
        Calculator calculator=new Calculator(mock);
        String s = calculator.manipulateData();
        assertEquals("Normal data found", s);
    }

    @Test
    void fourth_manipulateData_normalDataFoundWithParameter(){
        Calculator calculator=new Calculator(mock);
        String s = calculator.manipulateData1();
        assertEquals("Normal data found", s);
    }

    //below 2 test methods to check void method using Mockito.verify
    @Test
    void fifth_printMethod_greaterThan2Case(){
        Calculator calculator=new Calculator(mock);
        Mockito.when(mock.getDataFromAnotherMS()).thenReturn("Hello");
        calculator.print();
        Mockito.verify(mock, Mockito.times(1)).getDataFromAnotherMS();
        Mockito.verify(mock, Mockito.times(1)).getDBConnection();
        Mockito.verify(mock, Mockito.times(1)).addition(ArgumentMatchers.anyInt());
    }
    @Test
    void sixth_printMethod_lessThan2Case(){
        Calculator calculator=new Calculator(mock);
        Mockito.when(mock.getDataFromAnotherMS()).thenReturn("Hi");
        calculator.print();
        Mockito.verify(mock, Mockito.times(1)).getDataFromAnotherMS();
        Mockito.verify(mock, Mockito.times(2)).addition(ArgumentMatchers.anyInt());
    }


}
