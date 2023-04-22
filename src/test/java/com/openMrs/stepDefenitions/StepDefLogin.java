package com.openMrs.stepDefenitions;

import com.openMrs.pages.LoginPage;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import utils.ConfigReader;
import utils.DriverHelper;

public class StepDefLogin {
    WebDriver driver= DriverHelper.getDriver();
    LoginPage loginPage=new LoginPage(driver);

    @Given("User provides username and password with {string}")
    public void userProvidesUsernameAndPasswordWith(String location) {
        loginPage.loginValidation(ConfigReader.readProperty("QA_username"),ConfigReader.readProperty("QA_password"),location);

    }
    @Then("User validates the {string} and {string}")
    public void userValidatesTheAnd(String expestedTitle, String expectedUrl) {
        Assert.assertEquals(expestedTitle,driver.getTitle().trim());
        Assert.assertEquals(expectedUrl,driver.getCurrentUrl().trim());

    }
    @Given("User provides {string} and {string} with {string}")
    public void userProvidesAndWith(String username, String password, String location) {
        loginPage.loginValidation(username,password,location);


    }
    @Then("User validates {string}")
    public void userValidates(String message) {
        Assert.assertEquals(message,loginPage.validateErrorMessage());

    }
}
