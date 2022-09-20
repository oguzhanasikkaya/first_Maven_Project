package com.cydeo.crm;

import com.cydeo.pages.CrmLoginPage;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CrmLoginTest {

    @Test
    public void positiveLoginTest()  {
        Driver.getDriver().get(ConfigurationReader.getProperty("crm.url"));

        CrmLoginPage loginPage = new CrmLoginPage();

//        loginPage.email.sendKeys(ConfigurationReader.getProperty("crm.helpdesk3.username"));
//        loginPage.password.sendKeys(ConfigurationReader.getProperty("crm.password"));
//        loginPage.singInBtn.click();

        loginPage.login("crm.helpdesk3.username","crm.password");
    }
   // @Test
    public void  negativeLoginTest(){

        Driver.getDriver().get(ConfigurationReader.getProperty("crm.url"));

        CrmLoginPage loginPage = new CrmLoginPage();

//        loginPage.email.sendKeys("wrongemail@gmail.com");
//        loginPage.password.sendKeys("1234567");
//        loginPage.singInBtn.click();

        loginPage.login("oguzhanasikkaya@gmail.com","123456");

        Assert.assertEquals(loginPage.errorMsg,Driver.getDriver().findElement(By.xpath("//div[@class='errortext']")));

    }





}







