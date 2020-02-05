package com.vytrack.step_definitions;

import com.vytrack.pages.*;
import com.vytrack.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

public class ContactsStepDefs {

    @Then("the user should see following menu options")
    public void the_user_should_see_following_menu_options(List<String> menuOptions) {
        System.out.println("menuOptions.size = " + menuOptions.size());
        System.out.println("Menu options: " +menuOptions);
        //get value from website
        BrowserUtils.waitFor(2);
        DashboardPage dashboardPage = new DashboardPage();
        List<String> actualMenuOptions = BrowserUtils.getElementsText(dashboardPage.menuOptions);
        System.out.println(actualMenuOptions);

        //compare actual list from website and expected list from scenario
        Assert.assertEquals(menuOptions,actualMenuOptions);

    }

    @When("the use logs in using following credentials")
    public void the_use_logs_in_using_following_credentials(Map<String,String> userData) {
        new LoginPage().login(userData.get("username"),userData.get("password"));
        //verify fullname on the top right corner from website with firstname,lastname from map

        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.waitUntilLoaderScreenDisappear();
        String actualFullname = dashboardPage.getUserName();
        String expectedFullname= userData.get("firstname")+" "+userData.get("lastname");

        Assert.assertEquals(expectedFullname,actualFullname);

    }

    @When("the user click the {string} from contacts")
    public void the_user_click_the_from_contacts(String email) {

        BrowserUtils.waitFor(2);
        //click the row with the email
        ContactsPage contactsPage = new ContactsPage();
        contactsPage.getContactEmail(email).click();

    }

    @Then("the information should be the same with database")
    public void the_information_should_be_the_same_with_database() {
        //getting information from UI-GUI-Front-End-Browser
        ContactInfoPage contactInfoPage = new ContactInfoPage();
        String actualFullname = contactInfoPage.contactFullName.getText();
        String actualEmail = contactInfoPage.email.getText();
        String actualPhone = contactInfoPage.phone.getText();

        System.out.println("actualFullname = " + actualFullname);
        System.out.println("actualEmail = " + actualEmail);
        System.out.println("actualPhone = " + actualPhone);

        //get information from database



    }



}