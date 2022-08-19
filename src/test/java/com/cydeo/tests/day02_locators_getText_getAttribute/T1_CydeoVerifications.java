package com.cydeo.tests.day02_locators_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class T1_CydeoVerifications {

    public static void main(String[] args) {
        // create our browser
        WebDriverManager.chromedriver().setup();
        // run our browser
        WebDriver driver = new ChromeDriver();
        //maximize screen
        driver.manage().window().maximize();
        //go to https://practice.cydeo.com
        driver.get("https://practice.cydeo.com");
        //driver.navigate().to("https://practice.cydeo.com")

        //verify url contains, expected: cydeo
        String expectedURL = "cydeo";
        String actualURL = driver.getCurrentUrl();

        if (actualURL.contains(expectedURL)){
            System.out.println("test passed");
        }else {
            System.out.println("test failed");
        }

        //Verify title, expected Practice
        String expectedTitle = "Practice";
        String actualTitle = driver.getTitle() ;

        if (actualTitle.equals(expectedTitle)){
            System.out.println("test passed");
        }else {
            System.out.println("test failed");
        }


        driver.quit();


    }
}
