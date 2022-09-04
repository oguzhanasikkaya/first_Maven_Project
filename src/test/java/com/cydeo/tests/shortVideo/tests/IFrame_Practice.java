package com.cydeo.tests.shortVideo.tests;

import com.cydeo.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;

public class IFrame_Practice extends TestBase {
    @Test
    public void iframeTest(){
        driver.get("https://practice.cydeo.com/iframe");

  /*      //-----------------1---------------------------
        WebElement iframe = driver.findElement(By.id("mce_0_ifr"));
        driver.switchTo().frame(iframe);
        //-----------------2---------------------------
        driver.switchTo().frame(0);*/
        //-----------------3---------------------------
        driver.switchTo().frame("mce_0_ifr");


        WebElement  textArea = driver.findElement(By.tagName("p"));

        assertTrue(textArea.isDisplayed());

        driver.switchTo().parentFrame();
    }
}
