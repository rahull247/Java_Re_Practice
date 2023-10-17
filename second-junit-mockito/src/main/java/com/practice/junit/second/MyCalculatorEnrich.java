package com.practice.junit.second;

public class MyCalculatorEnrich {

    private MyClass myClass=new MyClass();

    public int add(int a, int b){
        if(a==0){
            throw new RuntimeException("Zero is not allowed for first parameter");
        }
        if(b==0){
            throw new RuntimeException("Zero is not allowed for second parameter");
        }

        int c = myClass.enrich(a);
        int d = myClass.enrich(b);

        return c+d;
    }
}
