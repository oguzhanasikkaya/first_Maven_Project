package com.cydeo.tests.day06_Alert_Iframe_Window;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class T5_WindowPractice {

    WebDriver driver;
    @BeforeMethod
    public void setupMethod(){
        driver = WebDriverFactory.getDriver("Chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // got to Website: http://practice.cydeo.com/javascript_alerts
        driver.get("https://practice.cydeo.com/windows");
    }
    @AfterMethod

    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }

    @Test
    public void windowHandle() throws InterruptedException {
        //Storing the main page's window handlw as string is
        //good practice for future re-usable purposes
        String mainHandle = driver.getWindowHandle();

        // Assert: Title is “Windows”
        Assert.assertEquals(driver.getTitle(),"Windows");

        // Click to: “Click Here” link
        WebElement newWindowButton = driver.findElement(By.linkText("Click Here"));
        newWindowButton.click();
        Thread.sleep(2000);
        String secondHandle = driver.getWindowHandle();

        /*driver.switchTo().window(mainHandle);
        newWindowButton.click();
        Thread.sleep(2000);
        String secondHandle = driver.getWindowHandle();

        driver.switchTo().window(mainHandle);
        newWindowButton.click();
        Thread.sleep(2000);
        String thirdHandle = driver.getWindowHandle();

        driver.switchTo().window(mainHandle);
        newWindowButton.click();
        Thread.sleep(2000);
        String forthHandle = driver.getWindowHandle();*/


        for (String each : driver.getWindowHandles()) {
            driver.switchTo().window(each);
            System.out.println("current title while switching windows: "+ driver.getTitle());
        }

        System.out.println("Click after the title: "+driver.getTitle());


        // Switch to new Window.


        //Assert: Title is “New Window”
        Assert.assertEquals(driver.getTitle(),"New Window");



    }





}
