package com.cydeo.shortVideo.tests;

import com.cydeo.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class P03_ActionClass  extends TestBase {

    @Test
    public void dragAndDropTest(){
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");
        WebElement smallCircle = driver.findElement(By.id("draggable"));
        WebElement bigCircle = driver.findElement(By.id("droptarget"));

        Actions actions = new Actions(driver);
       // actions.dragAndDrop(smallCircle,bigCircle).perform();

        actions.moveToElement(smallCircle).pause(2000).clickAndHold().pause(2000).
                moveToElement(bigCircle).pause(2000).release().perform();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

         assertEquals(bigCircle.getText(),"You did great!");
    }



}
