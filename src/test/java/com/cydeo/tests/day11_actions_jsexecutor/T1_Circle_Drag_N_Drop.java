package com.cydeo.tests.day11_actions_jsexecutor;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T1_Circle_Drag_N_Drop {

    @Test
    public void drag_drop_test(){
        //1. Go to https://demos.telerik.com/kendo-ui/dragdrop/index
        Driver.getDriver().get("https://demos.telerik.com/kendo-ui/dragdrop/index");

        //Locate "Accept Cookies" button and click
        WebElement acceptCookieButton = Driver.getDriver().findElement(By.id("onetrust-accept-btn-handler"));
        acceptCookieButton.click();

        //2. Drag and drop the small circle to bigger circle.
        WebElement smallCircle = Driver.getDriver().findElement(By.id("draggable"));
        WebElement bigCircle = Driver.getDriver().findElement(By.id("droptarget"));

        Actions actions = new Actions(Driver.getDriver());
        BrowserUtils.sleep(2);
        actions.dragAndDrop(smallCircle,bigCircle).perform();

        //3. Assert:
        //-Text in big circle changed to: “You did great!”

        String actualCircleText = bigCircle.getText();
        String expectedCircleText = "You did great!";

        Assert.assertEquals(expectedCircleText,actualCircleText);
    }
}
