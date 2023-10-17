package com.practice.junit.third;

public class MyClass {
    private String connection;
    private String httpClient;

    public void setConnection(String connection){
        this.connection=connection;
    }

    public int addition(int number){
        return number+2;
    }
    public String getDBConnection(String parameter){
        if (connection != null){
            return "Coming from db";
        }

        throw new RuntimeException("Database connection is null");
    }

    public String getDBConnection(){
        if (connection != null){
            return "Coming from db";
        }

        throw new RuntimeException("Database connection is null");
    }

    public String getDataFromAnotherMS(){
        if (connection != null){
            return "Coming from another microservice";
        }

        throw new RuntimeException("Another ms is null");
    }

}
