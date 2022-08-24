package com.cydeo.tests.day04_findElements_checkboxes_radio;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T1_xpath_cssSelector_practice {
    public static void main(String[] args) throws InterruptedException {

//        1. Open Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
//        2. Go to https://practice.cydeo.com/forgot_password
        driver.get("https://practice.cydeo.com/forgot_password");
//        3. Locate all the WebElements on the page using XPATH and/or CSS
//        locator only (total of 6)
//        a. “Home” link
        //cssSelector
        WebElement homeButtonCSS = driver.findElement(By.cssSelector("a[class='nav-link']"));
        homeButtonCSS.click();
        Thread.sleep(3000);

        driver.navigate().back();

        Thread.sleep(3000);

        //xpath
        WebElement homeButtonXPath = driver.findElement(By.xpath("//a[@class='nav-link']"));
        homeButtonXPath.click();

        Thread.sleep(3000);

        driver.navigate().back();

//        b. “Forgot password” header
        //CSS selector
        WebElement forgotPasswordHeaderCSS = driver.findElement(By.cssSelector("div[class='example']>h2"));
        System.out.println("forgotPasswordHeaderCSS.getText() = " + forgotPasswordHeaderCSS.getText());
        //xPath
        WebElement forgotPasswordHeaderXPath = driver.findElement(By.xpath("//div[@id=\"content\"]/div/h2"));
        System.out.println("forgotPasswordHeaderXPath.getText() = " + forgotPasswordHeaderXPath.getText());


//        c. “E-mail” text

        //cssSelector
        WebElement emailTextCSS = driver.findElement(By.cssSelector("label[for='email']"));
        System.out.println("emailTextCSS.getText() = " + emailTextCSS.getText());
        //xpath
        WebElement emailTextXPath = driver.findElement(By.xpath("//label[@for='email']"));
        System.out.println("emailTextXPath.getText() = " + emailTextXPath.getText());

//        d. E-mail input box
        //cssSelector
        WebElement emailBoxCss = driver.findElement(By.cssSelector("input[type='text']"));
        emailBoxCss.sendKeys("oguzhanasikkaya@gmail.com");
        Thread.sleep(3000);
        emailBoxCss.clear();

        //xpath
        WebElement emailBoxXpath = driver.findElement(By.xpath("//input[@name='email']"));
        emailBoxXpath.sendKeys("oguzhanasikkaya@yahoo.com");
        Thread.sleep(3000);
        emailBoxCss.clear();


//        e. “Retrieve password” button
        WebElement retrievePasswordButton = driver.findElement(By.xpath("//button[@id='form_submit']"));
        retrievePasswordButton.click();
        Thread.sleep(3000);
        driver.findElement(By.id("form_submit")).click();

//        f. “Powered by Cydeo text
        WebElement poweredByCydeoText = driver.findElement(By.xpath("//div[@style='text-align: center;']"));
        System.out.println("poweredByCydeoText.getText() = " + poweredByCydeoText.getText());


//        4. Verify all web elements are displayed.
        System.out.println("homeButtonCSS.isDisplayed() = " + homeButtonCSS.isDisplayed());
        System.out.println("homeButtonXPath.isDisplayed() = " + homeButtonXPath.isDisplayed());
        System.out.println("forgotPasswordHeaderCSS.isDisplayed() = " + forgotPasswordHeaderCSS.isDisplayed());
        System.out.println("forgotPasswordHeaderXPath.isDisplayed() = " + forgotPasswordHeaderXPath.isDisplayed());
        System.out.println("emailBoxCss.isDisplayed() = " + emailBoxCss.isDisplayed());
        System.out.println("emailBoxXpath.isDisplayed() = " + emailBoxXpath.isDisplayed());
        System.out.println("poweredByCydeoText.isDisplayed() = " + poweredByCydeoText.isDisplayed());
        System.out.println("retrievePasswordButton.isDisplayed() = " + retrievePasswordButton.isDisplayed());

        try {
            WebElement test = driver.findElement(By.id("test"));
        }catch (NoSuchElementException e) {
            e.printStackTrace();

        }



        Thread.sleep(4000);
        driver.quit();



    }
}
