package com.cydeo.tests.shortVideo.tests;

import com.cydeo.base.TestBase;
import com.cydeo.utilities.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class CRMLogin extends TestBase {

    @Test
    public void crmLogin(){
        driver.get(ConfigurationReader.getProperty("env"));

        // Enter valid username
        WebElement inputUsername = driver.findElement(By.xpath("//input[@name='USER_LOGIN']"));
        inputUsername.sendKeys(ConfigurationReader.getProperty("username"));

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


        // Enter valid password
        WebElement inputPassword = driver.findElement(By.xpath("//input[@name='USER_PASSWORD']"));
        inputPassword.sendKeys(ConfigurationReader.getProperty("password"));

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement loginButton = driver.findElement(By.xpath("//input[@value='Log In']"));
        loginButton.click();
    }

}
