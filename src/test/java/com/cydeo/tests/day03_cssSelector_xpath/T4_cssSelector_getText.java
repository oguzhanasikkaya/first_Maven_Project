package com.cydeo.tests.day03_cssSelector_xpath;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T4_cssSelector_getText {

    public static void main(String[] args) {

//        1- Open a Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

//        2- Go to: https://login1.nextbasecrm.com/?forgot_password=yes
        driver.navigate().to("https://login1.nextbasecrm.com/?forgot_password=yes");
//        3- Verify “Reset password” button text is as expected:
//        Expected: Reset password
     // WebElement resetPasswordButton = driver.findElement(By.cssSelector("button[class='login-btn']"));
        WebElement resetPasswordButton = driver.findElement(By.cssSelector("button[value='Reset password']"));

        String expectedResetPasswordText ="Reset password";
        String actualResetPasswordText = resetPasswordButton.getText();

        if (expectedResetPasswordText.equals(actualResetPasswordText)){
            System.out.println("reset password verification passed!");
        }else {
           // System.out.println("expectedResetPasswordText = " + expectedResetPasswordText);
           // System.out.println("actualResetPasswordText = " + actualResetPasswordText);
            System.out.println("Reset Password verification failed!!!");
        }
        driver.quit();

    }
}
