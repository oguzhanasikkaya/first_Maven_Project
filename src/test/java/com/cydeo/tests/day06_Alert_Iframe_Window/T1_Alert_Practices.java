package com.cydeo.tests.day06_Alert_Iframe_Window;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class T1_Alert_Practices {
    public WebDriver driver;
    @BeforeMethod
    public void setupMethod(){
        driver = WebDriverFactory.getDriver("Chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // got to Website: http://practice.cydeo.com/javascript_alerts
        driver.get("http://practice.cydeo.com/javascript_alerts");
    }
    @AfterMethod
    public void tearDown()throws InterruptedException{
        Thread.sleep(2000);
        driver.quit();
    }
   // @Ignore
    @Test(priority = 1)
    public void alert_test1()throws InterruptedException{

//        Click to “Click for JS Alert” button
        WebElement jsAlertButton = driver.findElement(By.xpath("//button[.='Click for JS Alert']"));
        jsAlertButton.click();

//        4. Click to OK button from the alert
        Alert alert = driver.switchTo().alert();


        // click to ok button from the alert
        Thread.sleep(3000);
        alert.accept();

//        5. Verify “You successfully clicked an alert” text is displayed.
        WebElement resultText = driver.findElement(By.xpath("//p[@id='result']"));


        Assert.assertTrue(resultText.isDisplayed(),"Result text is not displayed!!!");

        String expectedText ="You successfully clicked an alert";
        String actualText = resultText.getText();
        Assert.assertEquals(expectedText,actualText,"result text is not matching");

    }
    //@Ignore
    @Test(priority = 2)
    public void alert_test2()throws InterruptedException{
//        3. Click to “Click for JS Confirm” button
        WebElement jsConfirmButton = driver.findElement(By.xpath("//button[@onclick='jsConfirm()']"));
        jsConfirmButton.click();
//        4. Click to OK button from the alert

        Alert alert = driver.switchTo().alert();
        Thread.sleep(2000);
        alert.accept();
//        5. Verify “You clicked: Ok” text is displayed.
        WebElement result = driver.findElement(By.xpath("//p[@id='result']"));

       // System.out.println("result.getText() = " + result.getText());
        Assert.assertEquals(result.getText(),"You clicked: Ok");
    }

   // @Ignore
    @Test(priority = 3)
    public void alert_test3()throws InterruptedException{
//        3. Click to “Click for JS Prompt” button
        WebElement jsPromptButton = driver.findElement(By.xpath("//button[@onclick='jsPrompt()']"));
        jsPromptButton.click();
//        4. Send “hello” text to alert
        Alert alert = driver.switchTo().alert();
        alert.sendKeys("hello");

//        5. Click to OK button from the alert
        alert.accept();



//        6. Verify “You entered:  hello” text is displayed.
        WebElement result = driver.findElement(By.xpath("//p[@id='result']"));

        Assert.assertEquals(result.getText(),"You entered: hello");
    }
}
