package com.cydeo.tests.shortVideo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class P04_FullScreenMode {

    public static void main(String[] args) {


        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://cydeo.com");

        driver.manage().window().maximize();

        //driver.manage().window().fullscreen();





    }
}
