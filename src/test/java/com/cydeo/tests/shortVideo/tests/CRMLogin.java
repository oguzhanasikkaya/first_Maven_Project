package com.cydeo.tests.shortVideo.tests;

import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class CRMLogin  {

    @Test
    public void crmLogin(){
        Driver.getDriver().get(ConfigurationReader.getProperty("env"));

        // Enter valid username
        WebElement inputUsername = Driver.getDriver().findElement(By.xpath("//input[@name='USER_LOGIN']"));
        inputUsername.sendKeys(ConfigurationReader.getProperty("username"));

        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


        // Enter valid password
        WebElement inputPassword = Driver.getDriver().findElement(By.xpath("//input[@name='USER_PASSWORD']"));
        inputPassword.sendKeys(ConfigurationReader.getProperty("password"));

        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement loginButton = Driver.getDriver().findElement(By.xpath("//input[@value='Log In']"));
        loginButton.click();
    }

}
