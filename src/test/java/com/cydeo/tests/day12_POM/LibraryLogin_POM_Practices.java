package com.cydeo.tests.day12_POM;

import com.cydeo.pages.LibraryLoginPage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LibraryLogin_POM_Practices {

    LibraryLoginPage libraryLoginPage = new LibraryLoginPage();
    @BeforeMethod
    public void setupMethod(){
        Driver.getDriver().get("https://library1.cydeo.com/");
    }
    @AfterTest
    public void tearDown(){
       // Driver.closeDriver();
    }

    @Test(priority = 1)
    public void required_field_error_message_test(){
    // 1- Open a chrome browser
    // 2- Go to: https://library1.cydeo.com
        //Driver.getDriver().get("https://library1.cydeo.com/"); we create beforeMethod

    // 3- Do not enter any information
    // 4- Click to “Sign in” button
        BrowserUtils.sleep(2);
        libraryLoginPage.singInBtn.click();

    // 5- Verify expected error is displayed:
    //    Expected: This field is required.
        Assert.assertTrue(libraryLoginPage.errorMessageFielRequired.isDisplayed());
        //Driver.closeDriver();
    }

    @Test(priority = 2)
    public void invalid_email_format_error_message_test(){
//        TC #2: Invalid email format error message test
//        1- Open a chrome browser
//        2- Go to: https://library1.cydeo.com
        //Driver.getDriver().get("https://library1.cydeo.com");

//        3- Enter invalid email format

        libraryLoginPage.inputUsername.sendKeys("something.something");

        libraryLoginPage.singInBtn.click();

//        4- Verify expected error is displayed:
//        Expected: Please enter a valid email address.
        Assert.assertTrue(libraryLoginPage.errorMessageValidEmail.isDisplayed());

        //Driver.closeDriver();
    }

    @Test(priority = 3)
    public void library_negative_login_test(){

//        1- Open a chrome browser
//        2- Go to: https://library1.cydeo.com
        //Driver.getDriver().get("https://library1.cydeo.com");

//        3- Enter incorrect username or incorrect password
        libraryLoginPage.inputUsername.sendKeys("wrong@email.com");
        libraryLoginPage.inputPassword.sendKeys("wrongPassword");
        libraryLoginPage.singInBtn.click();

//        4- Verify title expected error is displayed:
//        Expected: Sorry, Wrong Email or Password
        Assert.assertTrue(libraryLoginPage.errorMessageWrongEmailOrPassword.isDisplayed());
    }


}
