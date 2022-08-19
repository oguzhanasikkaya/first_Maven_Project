package com.cydeo.tests.day02_locators_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class T4_LibraryLoginPage {
    public static void main(String[] args) {
        //TC #4: Library verifications
        //1. Open Chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        //2. Go to https://library1.cydeo.com/login.html
        driver.get("https://library1.cydeo.com/login.html");

        WebElement usernameInput = driver.findElement(By.className("form-control"));
        usernameInput.sendKeys("oguzhanasikkaya@gmail.com");


        WebElement passwordInput = driver.findElement(By.id("inputPassword"));
        passwordInput.sendKeys("incorrect password");

        WebElement signButton = driver.findElement(By.tagName("button"));

        signButton.click();


        //3. Enter username: “incorrect@email.com”

        //4. Enter password: “incorrect password”


        //5. Click to Sign in button


        //6. Verify: visually “Sorry, Wrong Email or Password”
        //displayed
    }
}
