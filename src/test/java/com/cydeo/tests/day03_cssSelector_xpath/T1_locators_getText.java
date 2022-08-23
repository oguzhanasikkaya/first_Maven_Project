package com.cydeo.tests.day03_cssSelector_xpath;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T1_locators_getText {

    public static void main(String[] args) {

// TC #1: NextBaseCRM, locators and getText() practice
// 1- Open a Chrome browser
//        WebDriverManager.chromedriver().setup();
//        WebDriver driver = new ChromeDriver();
        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.manage().window().maximize();
// 2- Go to: https://login1.nextbasecrm.com/
        driver.get("https://login1.nextbasecrm.com/");
// 3- Enter incorrect username: “incorrect”
        WebElement username = driver.findElement(By.className("login-inp"));
        username.sendKeys("oguzhanasikkaya@gmail.com");
// 4- Enter incorrect password: “incorrect”
        WebElement inputPassword = driver.findElement(By.name("USER_PASSWORD"));
        inputPassword.sendKeys("123456");
// 5- Click to log in button.
        WebElement logInButton = driver.findElement(By.className("login-btn"));
        logInButton.click();
// 6- Verify error message text is as expected:
//    Expected: Incorrect login or password
        WebElement errorMessage = driver.findElement(By.className("errortext"));
        String expectedErrorMessage = "Incorrect login or password";
        String actualErrorMessage = errorMessage.getText();

        if (actualErrorMessage.equals(expectedErrorMessage)){
            System.out.println("Error message verification passed!");
        }else {
            System.out.println("Error Message verification Failed!!!");
        }



    }
}
