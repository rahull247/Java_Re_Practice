package com.practice.junit.first;

public class MyCalculator {
    public int add(int a, int b){
        if(a==0){
            throw new RuntimeException("Zero is not allowed for first parameter");
        }
        if(b==0){
            throw new RuntimeException("Zero is not allowed for second parameter");
        }

        return a+b;
    }
}
