package com.cydeo.tests.day10_Upload_Action_JSExecutor;

import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class T1_RegistrationForm {

    @Test
    public void registration_form_test(){

        Faker faker = new Faker();
        String firstname = faker.name().firstName();
        String lastname = faker.name().lastName();
        String password = faker.bothify("##??##??");
        String phoneNumber = faker.numerify("###-###-####");



//        1. Open browser
//        2. Go to website: https://practice.cydeo.com/registration_form
        Driver.getDriver().get(ConfigurationReader.getProperty("registration.form.url"));

//        3. Enter first name
        WebElement firstNameBox = Driver.getDriver().findElement(By.xpath("//input[@name='firstname']"));
        firstNameBox.sendKeys(firstname);

//        4. Enter last name
        WebElement lastNameBox = Driver.getDriver().findElement(By.xpath("//input[@name='lastname']"));
        lastNameBox.sendKeys(lastname);
//        5. Enter username
        WebElement usernameBox = Driver.getDriver().findElement(By.xpath("//input[@name='username']"));
        usernameBox.sendKeys(firstname+lastname);

//        6. Enter email address
        WebElement emailBox = Driver.getDriver().findElement(By.xpath("//input[@name='email']"));
        emailBox.sendKeys(firstname.toLowerCase()+lastname.toLowerCase()+"@gmail.com");
//        7. Enter password
        WebElement passwordBox = Driver.getDriver().findElement(By.xpath("//input[@name='password']"));
        passwordBox.sendKeys(password);
//        8. Enter phone number
        WebElement phoneNumberBox = Driver.getDriver().findElement(By.xpath("//input[@name='phone']"));
        phoneNumberBox.sendKeys(phoneNumber);
//        9. Select a gender from radio buttons
        WebElement maleRadioButton = Driver.getDriver().findElement(By.xpath("//input[@value='male']"));
        WebElement femaleRadioButton = Driver.getDriver().findElement(By.xpath("//input[@value='female']"));
        WebElement otherRadioButton = Driver.getDriver().findElement(By.xpath("//input[@value='other']"));

        maleRadioButton.click();

//        10. Enter date of birth
        WebElement birtDateBox = Driver.getDriver().findElement(By.xpath("//input[@name='birthday']"));
        //birtDateBox.sendKeys((CharSequence) faker.date().birthday(18,45));
       birtDateBox.sendKeys(faker.numerify("11/11/1911"));

//        11. Select Department/Office
        Select departmentDropdown = new Select(Driver.getDriver().findElement(By.xpath("//select[@name='department']")));
        departmentDropdown.selectByIndex(faker.number().numberBetween(1,9));


//        12. Select Job Title
        Select jobTitleDropdown = new Select(Driver.getDriver().findElement(By.xpath("//select[@name='job_title']")));
        jobTitleDropdown.selectByIndex(faker.number().numberBetween(1,8));

//        13. Select programming language from checkboxes
        WebElement cCheckbox = Driver.getDriver().findElement(By.id("inlineCheckbox1"));
        WebElement javaCheckbox = Driver.getDriver().findElement(By.id("inlineCheckbox2"));
        WebElement javaScriptCheckbox = Driver.getDriver().findElement(By.id("inlineCheckbox3"));

        javaCheckbox.click();

//        14. Click to sign up button
        WebElement singUpButton = Driver.getDriver().findElement(By.id("wooden_spoon"));
        singUpButton.click();

//        15. Verify success message “You’ve successfully completed registration.” is
//        displayed.
        WebElement successMessage = Driver.getDriver().findElement(By.xpath("//p"));
        //System.out.println(successMessage.getText());
        successMessage.isDisplayed();
    }

}
