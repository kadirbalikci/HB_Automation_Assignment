package com.hepsiBurada.pages;

import com.hepsiBurada.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(){
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(id="myAccount")
    public WebElement AccountMenu;

    @FindBy(id="login")
    public WebElement LoginButton;

    @FindBy(id="email")
    public WebElement userName;

    @FindBy(id="password")
    public WebElement password;

    @FindBy(xpath = "//*[text()='Giriş']")
    public WebElement submit;


    public void login(String userNameStr, String passwordStr) throws InterruptedException {

        Actions actions = new Actions(Driver.get());
        actions.moveToElement(AccountMenu).perform();

        LoginButton.click();
        Thread.sleep(3000);
        userName.sendKeys(userNameStr);
         password.sendKeys(passwordStr);
        Thread.sleep(3000);
        submit.click();
        // verification that we logged
    }


}
