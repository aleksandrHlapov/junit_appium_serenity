package com.qualitestgroup.serenity.cucumber.features.stepdefinitions;

import com.qualitestgroup.serenity.cucumber.features.pages.BasePage;
import com.qualitestgroup.serenity.cucumber.features.steps.LoginSteps;
import cucumber.api.PendingException;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.runtime.StepDefinition;
import net.thucydides.core.annotations.Steps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoginStepDefinitions {

    public static final Logger LOGGER = LoggerFactory.getLogger(LoginSteps.class);

    @Steps
    LoginSteps loginSteps;

    @Before
    public  void setPlatform() {
        String platform =  System.getProperty("testEnvironment");
        LOGGER.info("The platform is " + platform);
        if (platform.compareToIgnoreCase("android") == 0) {
            BasePage.setAndroid(true);
            BasePage.setIOS(false);
        }
        else {
            BasePage.setAndroid(false);
            BasePage.setIOS(true);
        }
    }

    @Given("^I am not logged in$")
    public void iAmNotLoggedIn(){
        LOGGER.info("Verifying no member is logged in");
        loginSteps.verifyLoginFormShown();
    }

    @When("I log in as '(.*)'")
    public void iLogInAsMemberRef(String memberName){
        LOGGER.info("Log in as member: "+memberName);
        loginSteps.logIn(memberName);
    }

    //use to verify that the correct member is logged in
    @Then("I am logged in as '(.*)'")
    public void iAmLoggedInAsRef(String memberName){
        LOGGER.info("Verify logged in as: "+memberName);
        loginSteps.verifyLoggedInAsMemberName(memberName);
    }

    @Then("^I am logged in$")
    public void iAmLoggedIn() {
        LOGGER.info("Verify logged in");
        loginSteps.verifyLoggedIn();
    }

}
