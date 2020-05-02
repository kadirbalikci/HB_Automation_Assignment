package com.hepsiBurada.pages;

import com.hepsiBurada.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {

    public DashboardPage(){
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(xpath="//*[@placeholder='Ürün, kategori veya marka ara']")
    public WebElement searchBox;

    @FindBy(xpath="//*[text()='ARA']")
    public WebElement searchButton;

    //@FindBy(className = "product-title title")
    //@FindBy(xpath = "//*[@class='product-detail']")
    @FindBy(xpath = "//*[@class='hb-pl-cn']")
    public WebElement itemDetailsButton;

    //@FindBy(xpath = "//*[text()='Sepetim']")
    @FindBy(xpath = "//*[@class='OldMyAccount-2OvEz OldMyAccount-3TYPj']")
    public WebElement SepetimButton;

   // @FindBy(className = "Icon-close SearchBoxOld-closeIcon")
    @FindBy(className = "SearchBoxOld-iconWrapper")
    public WebElement clearButton;
}

