package com.cydeo.tests.day08_properties_config_reader;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T4_Config_Practice {

    @Test
    public void config_test(){
        Driver.getDriver().get("https://www.google.com");

        WebElement googleSearchBox = Driver.getDriver().findElement(By.xpath("//input[@name='q']"));
        googleSearchBox.sendKeys("apple"+ Keys.ENTER);

        String actualTitle = Driver.getDriver().getTitle();

        String expectedTitle = "apple - Google'da Ara";

        Assert.assertEquals(actualTitle,expectedTitle);
    }


}
