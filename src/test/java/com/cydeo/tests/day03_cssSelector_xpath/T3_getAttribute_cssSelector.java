package com.cydeo.tests.day03_cssSelector_xpath;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T3_getAttribute_cssSelector {
    public static void main(String[] args) {

        // TC #3: NextBaseCRM, locators, getText(), getAttribute() practice
        //1- Open a chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        //2- Go to: https://login1.nextbasecrm.com/
        driver.get("https://login1.nextbasecrm.com/");
        //3- Verify “Log in” button text is as expected:
        //Expected: Log In
        // WebElement loginButton = driver.findElement(By.className("login-btn"));
        // WebElement loginButton = driver.findElement(By.cssSelector("input[class='login-btn']"));
        // WebElement loginButton = driver.findElement(By.cssSelector("input[type='submit']"));
        WebElement loginButton = driver.findElement(By.cssSelector("input[value='Log In']"));

        String expectedButtonText = "Log In";
        String actualButtonText = loginButton.getAttribute("value");
        System.out.println("loginButton.getText() = " + loginButton.getText());
        System.out.println("expectedButtonText = " + expectedButtonText);
        System.out.println("actualButtonText = " + actualButtonText);




/*
//PS: Inspect and decide which locator you should be using to locate web
//elements.
//PS2: Pay attention to where to get the text of this button from
*/

    }
}
