package com.cydeo.tests.shortVideo.TestNG;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static org.testng.Assert.assertTrue;

public class P02_Hard_Soft_Assertion {


    @Test
    public void hardAssertion(){
        Assert.assertEquals("apple","app");
        System.out.println("After Assertion failed1");
        assertTrue("orange".equals("oranger"));
        System.out.println("After Assertion failed2");

    }




    @Test
    public void softAssertion(){
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals("apple","app");
        System.out.println("after Assertion failed3");
        softAssert.assertTrue("orange".equals("oranger"));
        System.out.println("After assertion failed4");
        softAssert.assertAll();

    }


}
