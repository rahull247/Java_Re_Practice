package com.practice.junit.third;

public class Calculator {

    private MyClass myClass;

    public Calculator(MyClass myClass){
        this.myClass=myClass;
    }


    public String manipulateData(){
        String dbConnection = myClass.getDBConnection();

        if (dbConnection == null){
            return "No data found!";
        }

        if (dbConnection.length() > 2){
            return "Greater than 2 data found";
        }

        return "Normal data found";
    }

    public String manipulateData1(){
        String dbConnection = myClass.getDBConnection("Hello");

        return "Normal data found";
    }

    void print(){
        String dataFromAnotherMS = myClass.getDataFromAnotherMS();
        if (dataFromAnotherMS.length() > 2){
            String dbConnection1 = myClass.getDBConnection();
            System.out.println("From db: " + dbConnection1);
        }else {
            int addition = myClass.addition(2);
            System.out.println("addition result: " + addition);
        }
        int addition2 = myClass.addition(2);
        System.out.println("addition2 result: " + addition2);
        System.out.println("Exit from print() method");
    }


}
