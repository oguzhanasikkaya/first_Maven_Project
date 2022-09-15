package com.cydeo.tests.day09_javafaker_driverUtil;

import com.github.javafaker.Faker;

public class JavaFakerPractice {
    public static void main(String[] args) {
        Faker faker = new Faker();
       // Faker faker = new Faker(new Locale("tr"));

        System.out.println(faker.name().firstName().toUpperCase());
        System.out.println(faker.name().lastName());


    }
}
