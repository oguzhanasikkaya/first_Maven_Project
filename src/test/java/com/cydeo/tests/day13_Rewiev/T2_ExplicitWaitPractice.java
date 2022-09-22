package com.cydeo.tests.day13_Rewiev;

import com.cydeo.pages.DynamicControlsPage;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class T2_ExplicitWaitPractice {

    DynamicControlsPage dynamicControlsPage;

    @BeforeMethod
    public void setupMethod(){
        //        1- Open a chrome browser
//        2- Go to: https://practice.cydeo.com/dynamic_controls
        Driver.getDriver().get("https://practice.cydeo.com/dynamic_controls");
        dynamicControlsPage = new DynamicControlsPage();
    }

    @Test
    public void test(){
//        3- Click to “Remove” button
        dynamicControlsPage.removeButton.click();
        Driver.getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),10);
        wait.until(ExpectedConditions.invisibilityOf(dynamicControlsPage.loadingBar));

//        4- Wait until “loading bar disappears”
//        5- Verify:
//        a. Checkbox is not displayed
        try{
            Assert.assertFalse(dynamicControlsPage.checkbox.isDisplayed());
            //  Assert.assertTrue(!dynamicControlsPage.checkBox.isDisplayed());

        }catch (NoSuchElementException n){
            Assert.assertTrue(true);
        }

//        b. “It’s gone!” message is displayed.

        Assert.assertTrue(dynamicControlsPage.message.isDisplayed());
        Assert.assertTrue(dynamicControlsPage.message.getText().equals("It's gone!"));
    }

}
