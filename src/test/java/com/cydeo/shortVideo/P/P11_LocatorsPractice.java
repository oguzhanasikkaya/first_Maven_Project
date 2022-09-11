package com.cydeo.shortVideo.P;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class P11_LocatorsPractice {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://app.vytrack.com/user/login");

        WebElement username = driver.findElement(By.id("prependedInput"));
        username.sendKeys("abcd");

        WebElement password = driver.findElement(By.id("prependedInput2"));
        password.sendKeys("1234");

        WebElement loginButton = driver.findElement(By.id("_submit"));
        loginButton.click();


        WebElement alert = driver.findElement(By.className("alert"));

        if (alert.getText().equals("Invalid user name or password.")){
            System.out.println("passed");
        }else {
            System.out.println("failed");
        }
        //-----------------------------------------------------------------

        String actualURL = driver.getCurrentUrl();
        if (actualURL.contains("vytrack")){
            System.out.println("URL is Passed");
        }else {
            System.out.println("URL is Failed");
        }
        //---------------------------------------------------------

        driver.findElement(By.partialLinkText("Forgot")).click();

        if (driver.getTitle().equals("Forgot Password")){
            System.out.println("Title is correct");
        }else {
            System.out.println("Title is not correct");
        }



    }
}
