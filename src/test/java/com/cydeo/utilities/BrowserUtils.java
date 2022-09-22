package com.cydeo.utilities;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class BrowserUtils {

    /**
    This method will accept int (int seconds) and execute Thread.sleep for given duration
     */
    public static void sleep ( int second){
        second*=1000;
        try{
            Thread.sleep(second);
        }catch (InterruptedException e){

        }
    }

    /**
    This method accepts 2 argument.
    Arg 1 expectedInUrl : for verify if the url contains given String
    Arg 2 expectedTitle to be compared against actualTitle
     */
    public static void switchWindowAndVerify(String expectingInUrl, String expectedInTitle){
        Set<String> allWindowHandles =Driver.getDriver().getWindowHandles();

        for (String each : allWindowHandles) {

            Driver.getDriver().switchTo().window(each);

            System.out.println("Current URL: "+ Driver.getDriver().getCurrentUrl());

            if (Driver.getDriver().getCurrentUrl().contains(expectingInUrl)){
                break;
            }
        }
        // Assert: Title contains expected title
        String actualTitle = Driver.getDriver().getTitle();

        Assert.assertTrue(actualTitle.contains(expectedInTitle));
    }

    /**
    This method accepts a String "expectedTitle" and Asserts if it is true
     */
    public static void verifyTitle(String expectedTitle){
        Assert.assertEquals(Driver.getDriver().getTitle(),expectedTitle);
    }


    /**
     * Create a utility method for ExpilicitWait so we don't have to repeat the lines
     */
    public static void waitForInvisibilityOf(WebElement webElement){

        Driver.getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),10);

        wait.until(ExpectedConditions.invisibilityOf(webElement));

    }


    /**
     * where we use this method: A web element should disappear in the page.
     * Browser wait until disappearing then,
     * We should assert disappearing
     */
    public static void waitAndAssertDisappearing(WebElement webElement){

        BrowserUtils.waitForInvisibilityOf(webElement);
    /** Wait until webElement disappears
    *  Verify: webElement is not displayed
    */
        try{
            Assert.assertFalse(webElement.isDisplayed());
            //  Assert.assertTrue(!dynamicControlsPage.checkBox.isDisplayed());
        }catch (NoSuchElementException n){
            Assert.assertTrue(true);
        }

    }


}
