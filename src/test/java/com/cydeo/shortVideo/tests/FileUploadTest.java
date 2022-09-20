package com.cydeo.shortVideo.tests;

import com.cydeo.tests.base.TestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class FileUploadTest extends TestBase {

    @Test
    public void fileUpload_test(){
        driver.get("http://practice.cydeo.com/upload");
        String filePath = "C:\\Users\\oguzh\\OneDrive\\Masaüstü\\woodenSpoon.jpg";

        driver.findElement(By.id("file-upload")).sendKeys(filePath);

        driver.findElement(By.id("file-submit")).click();

    }
}
