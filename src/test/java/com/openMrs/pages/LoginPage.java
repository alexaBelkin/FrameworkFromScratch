package com.openMrs.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

import java.util.List;

public class LoginPage {
    public LoginPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(css = "#username")
    WebElement username;
    @FindBy(css="#password")
    WebElement password;
    @FindBy(css = "#loginButton")
    WebElement clickLogin;
    @FindBy(xpath = "//ul[@id='sessionLocation']//li")
    List<WebElement> department;
    @FindBy(css = "#error-message")
    WebElement errorMessage;

    public void loginValidation(String username,String password,String departmentName){
        this.username.sendKeys(username);
        this.password.sendKeys(password);
        chooseLocation(departmentName);
        clickLogin.click();
    }
    public void chooseLocation(String departmentName){
        for (WebElement dep:department) {
            if(BrowserUtils.getText(dep).contains(departmentName)){
                dep.click();
                break;
            }
        }
    }
    public String validateErrorMessage(){
        return BrowserUtils.getText(errorMessage);
    }


}
