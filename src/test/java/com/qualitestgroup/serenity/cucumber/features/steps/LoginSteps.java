package com.qualitestgroup.serenity.cucumber.features.steps;

import com.qualitestgroup.serenity.cucumber.features.pages.LoginPage;
import com.qualitestgroup.serenity.cucumber.features.pages.MygiffgaffAccountPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.assertTrue;
import static org.assertj.core.api.Assertions.assertThat;

public class LoginSteps extends ScenarioSteps {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoginSteps.class);

    private LoginPage loginPage;
    private MygiffgaffAccountPage mygiffgaffAccountPage;

    @Step
    public void verifyLoginFormShown(){
        LOGGER.info("Verifying log in form is displayed.");
        assertTrue("Log in button not displayed!", loginPage.isLogInButtonDisplayed());
    }

    @Step
    public void logIn(String memberName){
        fillMemberDetails(memberName);
        clickLogin();
    }
    @Step
    public void fillMemberDetails(String memberName) {
        loginPage.fillUsername(memberName);
        loginPage.fillPassword("QualiTest123");
    }

    @Step
    public void clickLogin(){
        loginPage.clickLogIn();
    }

    @Step
    public void verifyLoggedInAsMemberName(String memberName){

        String loggedInMember = loginPage.getLoggedInMember();

        assertTrue("Member name in app not matching scenario input. Expected: "+memberName+ " GOT: "
                +loggedInMember, loggedInMember.contains(memberName));
    }

    public void verifyLoggedIn() {
        String myGoodybagsSection = mygiffgaffAccountPage.getTextForSection(0);
        assertThat(myGoodybagsSection).as("Member is not logged in").containsIgnoringCase("my goodybags");
    }
}
