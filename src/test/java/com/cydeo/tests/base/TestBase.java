package com.cydeo.tests.base;

import com.cydeo.utilities.WebDriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {

    protected WebDriver driver;

    @BeforeMethod
    public  void  setup(){
        driver = WebDriverFactory.getDriver("chrome");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void teardown()throws InterruptedException{
        Thread.sleep(2000);
        driver.close();
    }

}
