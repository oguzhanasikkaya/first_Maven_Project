package com.cydeo.tests.shortVideo.tests;

import com.cydeo.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.Set;

public class WindowHandle_Practice extends TestBase {

    @Test
    public void windowTest() throws InterruptedException {
        driver.get("https://practice.cydeo.com/windows");

        String currentHandle = driver.getWindowHandle();
        System.out.println("currentHandle = " + currentHandle);

        Set<String> allHandles = driver.getWindowHandles();
        System.out.println("allHandles = " + allHandles);

        WebElement clickButton = driver.findElement(By.linkText("Click Here"));
        clickButton.click();

        Thread.sleep(3000);

        System.out.println("After clicking driver.getWindowHandle() =\t" + driver.getWindowHandle());
        System.out.println("After clicking driver.getWindowHandles() =\t" + driver.getWindowHandles());

        allHandles = driver.getWindowHandles();

        for (String eachHandle : allHandles) {
            System.out.println("eachHandle = " + eachHandle);
            driver.switchTo().window(eachHandle);
            System.out.println("driver.getTitle() = " + driver.getTitle());
        }

        driver.switchTo().window(currentHandle);
        clickButton.click();
        Thread.sleep(3000);

        String thirdWindow = driver.getWindowHandle();
        driver.switchTo().window(currentHandle);
        Thread.sleep(3000);
        driver.switchTo().window(thirdWindow);

    }


}
