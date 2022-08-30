package com.cydeo.tests.day05_testNG_intro_dropdowns;

import org.testng.Assert;
import org.testng.annotations.*;

public class TestNG_Intro {

    @BeforeClass
    public void setupMethod(){
        System.out.println("--->Before class is running");
    }
    @AfterClass
    public void tearDownClass(){
        System.out.println("---> After Class is running");
    }

    @BeforeMethod
    public void setUpMethod(){
        System.out.println("-----> BeforeMethod is running!");
    }
    @AfterMethod
    public void tearDownMethod (){
        System.out.println("---> After Method is running!");
    }

    @Test(priority = 2)
    public void test2(){
        System.out.println("Test 2 is running...");

        //AssertTrue
        String actual = "apple";
        String expected = "apple";
        Assert.assertTrue(actual.equals(expected));
    }
    @Test(priority = 1)
    public void test1(){
        System.out.println("Test 1 is running...");

        //Assert Equals: compare 2 of the same things
        String actual = "apple1";
        String expected = "apple";

        Assert.assertEquals(actual,expected);
    }


}
