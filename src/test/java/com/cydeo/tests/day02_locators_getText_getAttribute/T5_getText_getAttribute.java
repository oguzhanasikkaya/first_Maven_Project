package com.cydeo.tests.day02_locators_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class T5_getText_getAttribute {

    public static void main(String[] args) {

        //1 open a Chrome browser

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();




        //2  go to https://practice.cydeo.com/registration_form

        driver.get("https://practice.cydeo.com/registration_form");

        //3 verify header text is as expected
        //Expected: Registration form
        WebElement headerText = driver.findElement(By.tagName("h2"));
        String expectedHeaderText ="Registration form";
        String actualHeaderText = headerText.getText();

        if (actualHeaderText.equals(expectedHeaderText)){
            System.out.println("header text passed");
        }else {
            System.out.println("header text failed");
        }

        //4 locate first name input box

        //5 verify placeholder attribute's  value is as expected: firs name


    }
}
