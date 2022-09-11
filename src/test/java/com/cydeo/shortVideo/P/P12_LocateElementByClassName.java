package com.cydeo.shortVideo.P;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class P12_LocateElementByClassName {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://google.com");

        WebElement location = driver.findElement(By.className("uU7dJb"));

        if (location.getText().equals("Türkiye")){
            System.out.println("Test passed");
        }else {
            System.out.println("Test failed");
        }
        driver.quit();
    }
}
