package com.cydeo.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class Driver {
    /**
    Creating a private constructor, so we are closing
    access to the object of this class from outside the class
     */
    private Driver(){}

    /**
    We make WebDriver private, because we want to close access from outside the class.
    We make it static because we will use it in a static method.
     */
    private static WebDriver driver; // value is null by default

    /**
    create a re-usable utility method which will return same driver instance when we call it
     */
    public static WebDriver getDriver(){

        if ( driver == null || driver.toString().toLowerCase().contains("null") ) {
            /**
            we read our browserType from configuration.properties.
            This way, we can control which browser is opened from outside our code, from configuration.properties file
             */
            String browserType = ConfigurationReader.getProperty("browser");

            /**
            Depending on the browserType that will be return from configuration.properties file
            switch statement will determine the case, and open the matching browser
             */

            switch (browserType) {

                case "chrome"   :
                default         :
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(11, TimeUnit.SECONDS);
                    break;
                case "firefox"  :
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(11, TimeUnit.SECONDS);
                    break;

            }
        }
        return driver;

    }

    /**
    This method will make sure our driver value is always null after using quit() method
     */
    public static void closeDriver(){
        if (driver != null){
            driver.quit();// this line will terminate the existing session. Value will not even be null
            driver = null;
        }
    }



}
