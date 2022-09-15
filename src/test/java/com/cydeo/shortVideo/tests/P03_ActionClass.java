package com.cydeo.shortVideo.tests;

import com.cydeo.tests.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

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

    @Test
    public void  hoverTest(){
        driver.get("https://practice.cydeo.com/hovers");

        WebElement firstImage = driver.findElement(By.xpath("(//img)[1]"));
        WebElement img1Text = driver.findElement(By.xpath("//h5[text()='name: user1']"));

        Actions actions = new Actions(driver);
        actions.moveToElement(firstImage).perform();
        assertTrue(img1Text.isDisplayed());


        List<WebElement> images = driver.findElements(By.tagName("img"));


        for (WebElement each : images) {
            actions.moveToElement(each).pause(2000).perform();
        }

    }



}
