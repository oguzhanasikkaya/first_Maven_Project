package com.cydeo.tests.day02_locators_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class T2_LinkTextPractice {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://practice.cydeo.com");
        //3 click to A/B testing from top of the list

        WebElement abTestLink = driver.findElement(By.linkText("A/B Testing"));

        //System.out.println(abTestLink); how I write this link on the console

        driver.findElement(By.linkText("A/B Testing")).click();


        //4 verify title is :
        //Expected: No A/B Test
        String expectedTitle ="No A/B Test";
        String actualTitle = driver.getTitle();

        if (actualTitle.equals(expectedTitle)){
            System.out.println("Title verification 1 PASSED!");
        }else {
            System.out.println("Title verification 1 FAILED!");
        }

        //5 Go back to home page by using the . back();
        driver.navigate().back();


        //6 verify title equals:
        //expected: Practice
        String expectedTitle2 ="Practice";
        String actualTitle2 = driver.getTitle();

        if (actualTitle2.equals(expectedTitle2)){
            System.out.println("Title verification 2 PASSED!");
        }else {
            System.out.println("Title verification 2 FAILED!");
        }

        driver.quit();



    }
}
