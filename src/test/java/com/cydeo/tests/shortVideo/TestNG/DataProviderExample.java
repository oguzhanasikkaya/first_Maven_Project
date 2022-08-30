package com.cydeo.tests.shortVideo.TestNG;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

import static org.testng.Assert.assertEquals;


public class DataProviderExample {

    WebDriver driver;
    @BeforeClass
    public void bismillah(){
        System.out.println("Bismillah");
    }

    @AfterClass
    public void hereWeGO(){
        System.out.println("Here We Go");
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
    @Test(dataProvider = "searchData")
    public void test1(String keyword, String expectedTitle){
        driver = WebDriverFactory.getDriver("Chrome");
        driver.get("https://google.com");
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys(keyword+ Keys.ENTER);

        assertEquals(driver.getTitle(),expectedTitle);

    }

    @DataProvider (name = "searchData")
    public Object [][] testData (){

        return new Object[][]{
                {"selenium","selenium - Google'da Ara"},
                {"java","java - Google'da Ara"},
                {"job","job - Google'da Ara"},
                {"cydeo","cydeo - Google'da Ara"},
        };
    }

}
