package com.cydeo.tests.day05_testNG_intro_dropdowns;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class T5_SelectAndVerifyDropDowns {

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
    public  void selectAndVerifyDropDown() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/dropdown");

        WebElement stateDropDowns = driver.findElement(By.xpath("//select[@id='state']"));

        Select selectState = new Select(stateDropDowns);

        selectState.selectByIndex(14);

        Thread.sleep(3000);

        selectState.selectByValue("VA");

        Thread.sleep(3000);

        selectState.selectByVisibleText("California");

        String expectedCaliforniaText ="California";

        String actualCaliforniaText = selectState.getFirstSelectedOption().getText();

        Assert.assertEquals(actualCaliforniaText,expectedCaliforniaText);

    }

}
