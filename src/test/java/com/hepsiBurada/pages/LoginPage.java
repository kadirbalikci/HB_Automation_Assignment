package com.hepsiBurada.pages;

import com.hepsiBurada.utilities.Driver;
import org.openqa.selenium.JavascriptExecutor;
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

    @FindBy(id="txtUserName")
    public WebElement userName;

    @FindBy(id="txtPassword")
    public WebElement password;

    @FindBy(id = "btnLogin")
    public WebElement submit;

    @FindBy(css = "div.cookie-info > img")
    public WebElement cookiesClose;


    public void login(String userNameStr, String passwordStr) throws InterruptedException {

        Actions actions = new Actions(Driver.get());
        actions.moveToElement(AccountMenu).perform();

        JavascriptExecutor jse = (JavascriptExecutor) Driver.get();

        jse.executeScript("arguments[0].click();", LoginButton);

//        LoginButton.click();
        Thread.sleep(3000);
        userName.sendKeys(userNameStr);
         password.sendKeys(passwordStr);
        Thread.sleep(3000);
        submit.click();
        // verification that we logged
    }


}
