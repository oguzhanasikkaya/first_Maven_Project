package com.cydeo.tests.day10_Upload_Action_JSExecutor;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class T4_Scroll_MoveTo {

    @Test
    public void scroll_moveTo() throws InterruptedException {

//        1- Open a chrome browser
//        2- Go to: https://practice.cydeo.com/
        Driver.getDriver().get("https://practice.cydeo.com/");

//        3- Scroll down to “Powered by CYDEO”
        WebElement poweredByCydeoLink = Driver.getDriver().findElement(By.xpath("//div[text()='Powered by ']"));
//        4- Scroll using Actions class “moveTo(element)” method
        Actions actions = new Actions(Driver.getDriver());
        Thread.sleep(2000);
        actions.moveToElement(poweredByCydeoLink).perform();
        BrowserUtils.sleep(2);
        WebElement homeButton = Driver.getDriver().findElement(By.xpath("//a[@class='nav-link']"));
        actions.moveToElement(homeButton).perform();




    }

}
