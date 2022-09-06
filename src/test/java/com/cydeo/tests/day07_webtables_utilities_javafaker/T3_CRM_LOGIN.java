package com.cydeo.tests.day07_webtables_utilities_javafaker;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.CRM_Utilities;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class T3_CRM_LOGIN {


    @Test
    public void crm_login_test1(){
//        1. Create new test and make setups
//        2. Go to : http://login1.nextbasecrm.com/
        Driver.getDriver().get("http://login1.nextbasecrm.com/");


//        3. Enter valid username
        WebElement usernameBox = Driver.getDriver().findElement(By.xpath("//input[@name='USER_LOGIN']"));
        usernameBox.sendKeys("helpdesk1@cybertekschool.com");

//        4. Enter valid password
        WebElement passwordBox = Driver.getDriver().findElement(By.xpath("//input[@name='USER_PASSWORD']"));
        passwordBox.sendKeys("UserUser");

//        5. Click to `Log In` button
        WebElement loginButton = Driver.getDriver().findElement(By.xpath("//input[@type='submit']"));
        loginButton.click();
//        6. Verify title is as expected:
//        Expected: Portal
        BrowserUtils.verifyTitle("Portal");

    }
    @Test
    public void crm_login_test2(){
//        1. Create new test and make setups
//        2. Go to : http://login1.nextbasecrm.com/
        Driver.getDriver().get("http://login1.nextbasecrm.com/");

        CRM_Utilities.crn_login("helpdesk1@cybertekschool.com","UserUser");


//        6. Verify title is as expected:
//        Expected: Portal
        BrowserUtils.verifyTitle("Portal");

    }

}
