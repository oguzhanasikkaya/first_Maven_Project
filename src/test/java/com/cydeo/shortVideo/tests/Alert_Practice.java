package com.cydeo.shortVideo.tests;

import com.cydeo.tests.base.TestBase;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class Alert_Practice extends TestBase {

    @Test
    public  void alertTest(){
        driver.get("http://practice.cydeo.com/javascript_alerts");
        WebElement jsAlert = driver.findElement(By.xpath("//button[.='Click for JS Alert']"));
        jsAlert.click();

        Alert alert = driver.switchTo().alert();
        alert.accept();

        WebElement resultText = driver.findElement(By.id("result"));

        assertTrue(resultText.isDisplayed());
    }

}
