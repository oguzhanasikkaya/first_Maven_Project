package com.cydeo.tests.day06_Alert_Iframe_Window;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class T4_Iframe_Practice {

    WebDriver driver;

    @BeforeMethod
    public void setupMethod(){
        driver = WebDriverFactory.getDriver("Chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // got to Website: http://practice.cydeo.com/javascript_alerts
        driver.get("https://practice.cydeo.com/iframe");
    }

    //@Ignore
    @Test
    public void iframePractice(){

        //We need to switch driver's focus to iframe
        //option1 id attribute value
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='mce_0_ifr']")));
        //or
        //driver.switchTo().frame(0);
        //or
        //driver.switchTo().frame("mce_0_ifr");

        //locate the p tag
        WebElement yourContentGoesHereText = driver.findElement(By.xpath("//p"));

       //verify "An iFrame containing the TinyMCe WYSIWYG Editor
        //to be able to verify the header, we must switch back to main html
        driver.switchTo().parentFrame();

        WebElement headerText = driver.findElement(By.xpath("//h3"));

        //Assert.assertEquals(headerText.getText(),"An iFrame containing the TinyMCE WYSIWYG Editor");

        Assert.assertTrue(headerText.isDisplayed());





    }

}
