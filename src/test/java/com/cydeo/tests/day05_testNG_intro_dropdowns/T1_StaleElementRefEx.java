package com.cydeo.tests.day05_testNG_intro_dropdowns;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class T1_StaleElementRefEx {
    public static void main(String[] args) throws InterruptedException {

//        1. Open Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

//        2. Go to https://practice.cydeo.com/add_remove_elements/
        driver.get("https://practice.cydeo.com/add_remove_elements/");

//        3. Click to “Add Element” button
        WebElement addElementButton = driver.findElement(By.xpath("//button[@onclick='addElement()']"));

        Thread.sleep(3000);

        addElementButton.click();



//        4. Verify “Delete” button is displayed after clicking.

//        5. Click to “Delete” button.
        WebElement deleteElementButton = driver.findElement(By.xpath("//button[@class='added-manually']"));
        Thread.sleep(3000);

        System.out.println("deleteElementButton.isDisplayed() = " + deleteElementButton.isDisplayed());

        deleteElementButton.click();
//        6. Verify “Delete” button is NOT displayed after clicking.

        try {
            deleteElementButton.isDisplayed();

        }catch (StaleElementReferenceException e ){
            System.out.println("staleElementReferenceException is thrown");
            System.out.println("This means the web element is completely deleted from the page");
            System.out.println("deleteButton.isDisplayed() = false");
        }

//        USE XPATH LOCATOR FOR ALL WEBELEMENT LOCATORS



    }
}
