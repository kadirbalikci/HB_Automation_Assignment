package com.hepsiBurada.step_definitions;

import com.hepsiBurada.pages.DashboardPage;
import com.hepsiBurada.pages.LoginPage;
import com.hepsiBurada.pages.ProductPage;
import com.hepsiBurada.pages.SepetimPage;
import com.hepsiBurada.utilities.ConfigurationReader;
import com.hepsiBurada.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.*;

public class HBAssignmentStepDefs {

    DashboardPage dashboardPage = new DashboardPage();
    SepetimPage sepetimPage = new SepetimPage();
    ProductPage productPage = new ProductPage();
    WebDriverWait wait = new WebDriverWait(Driver.get(),15);

    @Given("the user is on the HB login page")
    public void the_user_is_on_the_HB_login_page() {
        String url = ConfigurationReader.get("url");
        Driver.get().get(url);

    }

    @Given("the user enter the valid credentials")
    public void the_user_enter_the_valid_credentials() throws InterruptedException {

        LoginPage loginPage = new LoginPage();
        String username = ConfigurationReader.get("HB_username");
        String password = ConfigurationReader.get("HB_password");
        loginPage.login(username,password);
    }

//            items         | titles                                          |
//            | HBV00000L7ZZO | Sinbo Shb 3117 1000 W Blender Seti              |
//            | HBV00000KKJ56 | Xiaomi Mi Band 4 Akıllı Bileklik Siyah          |
//            | hbv00000k41em | Xiaomi Redmi Airdots Tws Bluetooth 5.0 Kulaklık
    @When("user make a search through three different items")
    public void user_make_a_search_through_three_different_items() throws InterruptedException {
         List<String> itemCodeList = Arrays.asList("HBV00000L7ZZO","HBV00000KKJ56","hbv00000k41em");

        for (int i = 0; i <itemCodeList.size() ; i++) {
            wait.until(ExpectedConditions.visibilityOf(dashboardPage.searchBox));
            dashboardPage.searchBox.sendKeys(itemCodeList.get(i));
            Thread.sleep(3000);
            dashboardPage.searchButton.click();
          Thread.sleep(3000);
             dashboardPage.itemDetailsButton.click();
            Thread.sleep(3000);
             dashboardPage.clearButton.click();
        }
    }

    @Then("In the Sepetim page searched items should be displayed in Son Gezdikleriniz menu")
    public void in_the_Sepetim_page_searched_items_should_be_displayed_in_Son_Gezdikleriniz_menu() {
        List<String> expectedTitleList = Arrays.asList(  "Sinbo Shb 3117 1000 W Blender Seti",
                                                    "Xiaomi Mi Band 4 Akıllı Bileklik Siyah",
                                                    "Xiaomi Redmi Airdots Tws Bluetooth 5.0 Kulaklık");

        JavascriptExecutor executor = (JavascriptExecutor) Driver.get();
        executor.executeScript("arguments[0].click();", dashboardPage.SepetimButton);

        List<String> actualTitleList = new ArrayList<>();
        actualTitleList.add(sepetimPage.item1.getText());
        actualTitleList.add(sepetimPage.item2.getText());
        actualTitleList.add(sepetimPage.item3.getText());

        System.out.println(actualTitleList);

        for (int i = 0; i <actualTitleList.size() ; i++) {
            String expectedTitle = expectedTitleList.get(i).substring(0,25)+"...";
            assertEquals(expectedTitle, actualTitleList.get(i));
        }
    }
}