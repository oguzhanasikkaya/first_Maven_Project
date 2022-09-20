package com.cydeo.pages;

import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CrmLoginPage {

    public CrmLoginPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//input[@name='USER_LOGIN']")
    public WebElement email;

    @FindBy(xpath = "//input[@name='USER_PASSWORD']")
    public WebElement password;

    @FindBy(xpath = "//input[@type='submit']")
    public WebElement singInBtn;

    @FindBy(xpath = "//div[@class='errortext']")
    public WebElement errorMsg;

    public void login(String userName, String passWord){
        email.sendKeys(ConfigurationReader.getProperty(userName));
        password.sendKeys(ConfigurationReader.getProperty(passWord));
        singInBtn.click();
    }






}
