package com.cydeo.tests.day01_selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task1_YahooTitleVerification {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.get("https:www.yahoo.com");
        String title = driver.getTitle();
        title = title.toLowerCase();
        driver.manage().window().maximize();

        if (title.contains("yahoo")){
            System.out.println("Test passed");
        }else {
            System.out.println("Test failed");
        }
        driver.quit();




    }
}
