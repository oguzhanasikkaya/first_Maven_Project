package com.cydeo.tests.day05_testNG_intro_dropdowns;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class T7_NonSelectDropdown {
    WebDriver driver;

    @BeforeMethod
    public void setUpMethod(){
        driver = WebDriverFactory.getDriver("Chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void tearDownMethod(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();
    }

    @Test
    public void selectValueNonSelectDropDown()throws InterruptedException{

//        2. Go to https://practice.cydeo.com/dropdown
        driver.get("https://practice.cydeo.com/dropdown");

//        3. Click to non-select dropdown
        WebElement nonSelectDropdown = driver.findElement(By.xpath("//a[@id='dropdownMenuLink']"));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        nonSelectDropdown.click();
        Thread.sleep(3000);

//        4. Select Facebook from dropdown
        WebElement linkFacebook = driver.findElement(By.xpath("//a[@href='https://www.facebook.com/']"));
        linkFacebook.click();

//        5. Verify title is “Facebook - Log In or Sign Up”
        String actualTitle = driver.getTitle();
        String expectedTitle = "Facebook – log in or sign up";
        Assert.assertEquals(actualTitle,expectedTitle,"NOT MATCH");
    }
}
