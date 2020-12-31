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
   @FindBy(xpath = "//*[text()='Sinbo Shb 3117 1000 W Blender Seti']")
   public WebElement item3;

    //HBV00000KKJ56
    @FindBy(xpath = "//*[text()='Xiaomi Mi Band 4 Akıllı Bileklik Siyah']")
    public WebElement item2;

    //HBV00000L7ZZO
    @FindBy (xpath = "//*[text()='Xiaomi Redmi Airdots Tws Bluetooth 5.0 Kulaklık']")
    public WebElement item1;







}
