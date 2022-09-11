package com.cydeo.shortVideo.P;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class P05_LocateElementsById {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://google.com");

        WebElement luckyText = driver.findElement(By.id("gbqfbb"));

        String text = luckyText.getAttribute("value");

        if (text.equals("I'm Feeling Lucky")){
            System.out.println("Test passed");
        }else {
            System.out.println("test failed");
        }


    }
}
