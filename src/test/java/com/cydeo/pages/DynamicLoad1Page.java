package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DynamicLoad1Page {
    public DynamicLoad1Page() {
        PageFactory.initElements(Driver.getDriver(), this);

    }
    @FindBy(xpath = "//button[.='Start']")
    public WebElement  startBtn;

    @FindBy(id = "username")
    public WebElement usernameBox;

    @FindBy(id = "pwd")
    public WebElement passwordBox;

    @FindBy(xpath = "//button[.='Submit']")
    public WebElement submitBtn;

    @FindBy(id = "loading")
    public WebElement loadingBar;

    @FindBy(id = "flash")
    public WebElement errorMessage;
}
