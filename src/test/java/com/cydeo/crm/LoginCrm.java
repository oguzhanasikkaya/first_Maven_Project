package com.cydeo.crm;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LoginCrm {

    @Test
    public void username_hr_test() throws InterruptedException {

        for (int i = 99; i >0 ; i--) {

            Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            Driver.getDriver().get("https://qa.azulcrm.com/");

            WebElement loginBox = Driver.getDriver().findElement(By.xpath("//input[@name='USER_LOGIN']"));
            loginBox.sendKeys("hr"+i+"@cybertekschool.com");




            WebElement passwordBox = Driver.getDriver().findElement(By.xpath("//input[@name='USER_PASSWORD']"));
            passwordBox.sendKeys("UserUser"+ Keys.ENTER);


            WebElement profileBtn = Driver.getDriver().findElement(By.id("user-name"));

            String expectedResult =  "hr"+i+"@cybertekschool.com";
            String actualResult = profileBtn.getText();


            System.out.println(i);
            System.out.println("--------------------------");
            System.out.println(actualResult);

            Assert.assertEquals(actualResult,expectedResult);
            Driver.getDriver().quit();
        }


    }


   // @Test
    public void test1(){
        Driver.getDriver().get("https://www.google.com");
        System.out.println(Driver.getDriver());
        Driver.getDriver().quit();
        System.out.println(Driver.getDriver());
    }



}
