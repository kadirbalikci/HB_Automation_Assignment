package com.vytrack.step_definitions;

import com.vytrack.utilities.Driver;
import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.util.concurrent.TimeUnit;

public class Hooks {

    @Before("@db")
    public void setUpDatabase(){
        System.out.println("\tCONNECTION DATABASE");
    }

    @Before
    public void setUp(){
        Driver.get().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Driver.get().manage().window().fullscreen();
    }

    @After("@db")
    public void tearDownDatabase(){
        System.out.println("\tCLOSING DATABASE CONNECTION");
    }

    @After
    public void tearDown(Scenario scenario){
        //if the scenario fails take the screenshot
        if(scenario.isFailed()){
            final byte[] screenshot = ((TakesScreenshot) Driver.get()).getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot,"image/png");
        }

        Driver.closeDriver();
    }




}
