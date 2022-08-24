package com.HomeWork;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");
        driver.manage().window().maximize();
       /* driver.findElement(By.partialLinkText("Oturum")).click();
        driver.findElement(By.id("identifierId")).sendKeys("oguzhanasikkaya1@gmail.com"+ Keys.TAB+ Keys.TAB+ Keys.TAB+ Keys.ENTER);*/


    }
}
