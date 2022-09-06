package com.cydeo.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CRM_Utilities {

    /**
     * This method will login with helpdesk1@cybertekschoo.com
     * User when it is called
     */
    public static void crn_login(){
//         Enter valid username
        WebElement usernameBox = Driver.getDriver().findElement(By.xpath("//input[@name='USER_LOGIN']"));
        usernameBox.sendKeys("helpdesk1@cybertekschool.com");

//         Enter valid password
        WebElement passwordBox = Driver.getDriver().findElement(By.xpath("//input[@name='USER_PASSWORD']"));
        passwordBox.sendKeys("UserUser");

//         Click to `Log In` button
        WebElement loginButton = Driver.getDriver().findElement(By.xpath("//input[@type='submit']"));
        loginButton.click();
    }


    public static void crn_login(String username, String password){
//         Enter valid username
        WebElement usernameBox = Driver.getDriver().findElement(By.xpath("//input[@name='USER_LOGIN']"));
        usernameBox.sendKeys(username);

//         Enter valid password
        WebElement passwordBox = Driver.getDriver().findElement(By.xpath("//input[@name='USER_PASSWORD']"));
        passwordBox.sendKeys(password);

//         Click to `Log In` button
        WebElement loginButton = Driver.getDriver().findElement(By.xpath("//input[@type='submit']"));
        loginButton.click();
    }



}
