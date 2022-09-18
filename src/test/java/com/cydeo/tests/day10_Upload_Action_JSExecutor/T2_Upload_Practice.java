package com.cydeo.tests.day10_Upload_Action_JSExecutor;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T2_Upload_Practice {


    @Test
    public void upload_test(){
        //1. Go to https://practice.cydeo.com/upload
        Driver.getDriver().get("https://practice.cydeo.com/upload");

        //2. Find some small file from your computer, and get the path of it.
        String path = "C:\\Users\\oguzh\\OneDrive\\Masaüstü\\woodenSpoon.jpg";

        //3. Upload the file.
        WebElement chooseFileButton = Driver.getDriver().findElement(By.id("file-upload"));
        chooseFileButton.sendKeys(path);

        WebElement uploadButton = Driver.getDriver().findElement(By.id("file-submit"));
        uploadButton.click();
        //4. Assert:
        //-File uploaded text is displayed on the page
        WebElement message = Driver.getDriver().findElement(By.xpath("//h3"));
        Assert.assertTrue(message.isDisplayed());

    }
}
