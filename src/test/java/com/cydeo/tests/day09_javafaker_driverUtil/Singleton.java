package com.cydeo.tests.day09_javafaker_driverUtil;

public class Singleton {

    //#1 create private constructor

    private Singleton(){}


    //#1 create private static String
    //prevent access and provide a getter method
    private static String word;

    //This utility method will return the "word" in the way we want to return
    public static String getWord(){

        if (word == null){
            System.out.println("First time call. word object is null. assigning value to it now");
            word = "Wooden Spoon";

        }else {
            System.out.println("Word already has value");
        }
        return  word;
    }



}
