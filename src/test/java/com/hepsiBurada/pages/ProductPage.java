package com.hepsiBurada.pages;

import com.hepsiBurada.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {

    public ProductPage(){
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(className = "product-name best-price-trick")
    public WebElement itemTitle;

    public String getItemTitle() {
        return itemTitle.getText();
    }




}
