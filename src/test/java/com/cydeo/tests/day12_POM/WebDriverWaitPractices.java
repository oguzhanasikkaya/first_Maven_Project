package com.cydeo.tests.day12_POM;

import com.cydeo.pages.DynamicLoad1Page;
import com.cydeo.pages.DynamicLoad7Page;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WebDriverWaitPractices {

    @Test(priority = 1)
    public void dynamic_load_7_test(){
        //1. Go to https://practice.cydeo.com/dynamic_loading/7
        Driver.getDriver().get("https://practice.cydeo.com/dynamic_loading/7");

        //2. Wait until title is “Dynamic title”
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),10);
        BrowserUtils.sleep(5);

        wait.until(ExpectedConditions.titleIs("Dynamic title"));

        //3. Assert:
        DynamicLoad7Page dynamicLoad7Page = new DynamicLoad7Page();

        //Message “Done” is displayed.
        BrowserUtils.sleep(5);
        Assert.assertTrue(dynamicLoad7Page.doneMessage.isDisplayed());

        //4. Assert: Image is displayed.
        Assert.assertTrue(dynamicLoad7Page.spongeBobImg.isDisplayed());

        Driver.closeDriver();



    }

    @Test(priority = 2)
    public void dynamic_load_1_test(){
//        1. Go to https://practice.cydeo.com/dynamic_loading/1
        Driver.getDriver().get("https://practice.cydeo.com/dynamic_loading/1");

        DynamicLoad1Page dynamicLoad1Page = new DynamicLoad1Page();


//        2. Click to start
        dynamicLoad1Page.startBtn.click();


//        3. Wait until loading bar disappears
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),10);

        wait.until(ExpectedConditions.invisibilityOf(dynamicLoad1Page.loadingBar));

//        4. Assert username inputbox is displayed
        Assert.assertTrue(dynamicLoad1Page.usernameBox.isDisplayed());
//        5. Enter username: tomsmith
        dynamicLoad1Page.usernameBox.sendKeys("tomsmith");
//        6. Enter password: incorrectpassword
        dynamicLoad1Page.passwordBox.sendKeys("incorrectpssword");
//        7. Click to Submit button
        dynamicLoad1Page.submitBtn.click();
        wait.until(ExpectedConditions.visibilityOf(dynamicLoad1Page.errorMessage));
//        8. Assert “Your password is invalid!” text is displayed.
        Assert.assertTrue(dynamicLoad1Page.errorMessage.isDisplayed());

        Driver.closeDriver();
    }


}
