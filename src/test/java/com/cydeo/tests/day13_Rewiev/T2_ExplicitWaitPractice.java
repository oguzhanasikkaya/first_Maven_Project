package com.cydeo.tests.day13_Rewiev;

import com.cydeo.pages.DynamicControlsPage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

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
    public void wait_and_assert_test(){
//        3- Click to “Remove” button
        dynamicControlsPage.removeButton.click();
       /* Driver.getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),10);
        wait.until(ExpectedConditions.invisibilityOf(dynamicControlsPage.loadingBar));*/

        BrowserUtils.waitForInvisibilityOf(dynamicControlsPage.loadingBar);

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
    @Test
    public void enable_button_test(){

//        3- Click to “Enable” button
//        System.out.println("dynamicControlsPage.enableButton.isEnabled() = " + dynamicControlsPage.enableButton.isEnabled());
        dynamicControlsPage.enableButton.click();
        BrowserUtils.waitForInvisibilityOf(dynamicControlsPage.loadingBar);
        System.out.println("dynamicControlsPage.inputBox.isEnabled() = " + dynamicControlsPage.inputBox.isEnabled());

//        4- Wait until “loading bar disappears”
//        BrowserUtils.waitAndAssertDisappearing();
//        5- Verify:
//        a. Input box is enabled.
        Assert.assertTrue(dynamicControlsPage.inputBox.isEnabled());
//        b. “It’s enabled!” message is displayed.
        Assert.assertTrue(dynamicControlsPage.message.isDisplayed());
        //check the string value is matching as expected: "It's enabled!"
        Assert.assertTrue(dynamicControlsPage.message.getText().equals("It's enabled!"));

    }
}
