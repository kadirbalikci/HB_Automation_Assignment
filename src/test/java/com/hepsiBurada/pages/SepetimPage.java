package com.hepsiBurada.pages;

import com.hepsiBurada.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SepetimPage {

    //hbv00000k41em
    public SepetimPage(){
        PageFactory.initElements(Driver.get(), this);
    }
    @FindBy(xpath = "(//*[@class='product-title title'])[14]")
    public WebElement item3;

    //HBV00000KKJ56
    @FindBy(xpath = "(//*[@class='product-title title'])[15]")
    public WebElement item2;

    //HBV00000L7ZZO
    @FindBy(xpath = "(//*[@class='product-title title'])[16]")
    public WebElement item1;







}
