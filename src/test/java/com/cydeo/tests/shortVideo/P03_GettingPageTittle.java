package com.cydeo.tests.shortVideo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class P03_GettingPageTittle {

    public static void main(String[] args) {


        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://cydeo.com");


        String title = driver.getTitle();

        driver.quit();

        System.out.println("Title of the page: "+ title);

        if (title.equals("Cydeo")){
            System.out.println("test passed");
        }else {
            System.out.println("test failed");
        }



    }
}
