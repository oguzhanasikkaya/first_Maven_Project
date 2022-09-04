package com.cydeo.tests.shortVideo.TestNG;

import com.cydeo.base.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNG_Selenium extends TestBase {

    /*WebDriver driver;

    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }*/ //I create utulities so I don't need to this mothods

    @Test
    public void googleTitle(){
        driver.get("https://google.com");

        String expectedGoogleTitle ="Google";

        String actualGoogleTitle = driver.getTitle();

        Assert.assertEquals(actualGoogleTitle,expectedGoogleTitle,"Google Title is not matching");



    }


}
