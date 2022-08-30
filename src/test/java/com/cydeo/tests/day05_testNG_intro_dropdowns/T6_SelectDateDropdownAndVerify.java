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

public class T6_SelectDateDropdownAndVerify {
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
    public void selectDateDropdown() throws InterruptedException{
//  Go to https://practice.cydeo.com/dropdown
        driver.get("https://practice.cydeo.com/dropdown");
        Thread.sleep(3000);


// Select “December 1st, 1923” and verify it is selected.
//        Select year using  : visible text
        WebElement yearDropDown = driver.findElement(By.xpath("//select[@id='year']"));
        Select selectYear = new Select(yearDropDown);
        selectYear.selectByVisibleText("1923");
        Thread.sleep(3000);

//        Select month using   : value attribute
        WebElement monthDropDown = driver.findElement(By.xpath("//select[@id='month']"));
        Select selectMonth = new Select(monthDropDown);
        selectMonth.selectByValue("11");
        Thread.sleep(3000);

//        Select day using : index number
        WebElement dayDropDown = driver.findElement(By.xpath("//select[@id='day']"));
        Select selectDay = new Select(dayDropDown);
        selectDay.selectByIndex(0);
        Thread.sleep(3000);

        String expectedYear= "1923";
        String expectedMonth = "December";
        String expectedDay  ="1";

        String actualYear = selectYear.getFirstSelectedOption().getText();
        String actualMonth = selectMonth.getFirstSelectedOption().getText();
        String actualDay = selectDay.getFirstSelectedOption().getText();

        Assert.assertEquals(actualYear,expectedYear);
        Assert.assertEquals(actualMonth, expectedMonth);
        Assert.assertEquals(actualDay,expectedDay);
    }
}
