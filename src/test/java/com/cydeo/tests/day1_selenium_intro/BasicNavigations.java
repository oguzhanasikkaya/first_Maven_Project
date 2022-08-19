package com.cydeo.tests.day1_selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicNavigations {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.tesla.com");

        //Stop code execution for 3 seconds
        Thread.sleep(3000);

        //use selenium to navigate back
        driver.navigate().back();

        Thread.sleep(3000);

        driver.navigate().forward();

        Thread.sleep(3000);

        //use selenium to navigate refresh

        driver.navigate().refresh();

        driver.navigate().to("https://www.google.com");

        //get the title of the page
        System.out.println("driver.getTitle() = " + driver.getTitle());

        String currentURL = driver.getCurrentUrl();

        System.out.println(currentURL);


        Thread.sleep(3000);
        driver.close();

    }
}
