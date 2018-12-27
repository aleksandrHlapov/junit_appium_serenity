package com.qualitestgroup.serenity.cucumber.features.pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage{


    @AndroidFindBy(id = "com.giffgaffmobile.controller:id/userNameEditText")
    @iOSFindBy(xpath = "//XCUIElementTypeApplication[@name=\"my giffgaffβ\"]/XCUIElementTypeWindow[1]/XCUIElementTypeScrollView/XCUIElementTypeTextField")
    @FindBy(xpath = "//XCUIElementTypeApplication[@name=\"my giffgaffβ\"]/XCUIElementTypeWindow[1]/XCUIElementTypeScrollView/XCUIElementTypeTextField")
    private WebElement usernameField;

    @AndroidFindBy(id = "com.giffgaffmobile.controller:id/passwordEditText")
    @iOSFindBy(xpath = "//XCUIElementTypeApplication[@name=\"my giffgaffβ\"]/XCUIElementTypeWindow[1]/XCUIElementTypeScrollView/XCUIElementTypeSecureTextField")
    @FindBy(xpath = "//XCUIElementTypeApplication[@name=\"my giffgaffβ\"]/XCUIElementTypeWindow[1]/XCUIElementTypeScrollView/XCUIElementTypeSecureTextField")
    private WebElement passwordField;

    @AndroidFindBy(id = "com.giffgaffmobile.controller:id/buttonLogin")
    @iOSFindBy(xpath = "//XCUIElementTypeButton[@name=\"Login\"]")
    @FindBy( xpath = "//XCUIElementTypeButton[@name=\"Login\"]")
    private WebElement loginButton;

    // mainNav
    //AndroidFindBy(uiAutomator = "description(\"Open navigation drawer\")")
    @AndroidFindBy(id = "Open navigation drawer")
    @iOSFindBy(uiAutomator = ".navigationBars()[0].buttons().firstWithPredicate(\"label like 'reveal icon'\")")
    private WebElement dropdownMenuButton;

    @AndroidFindBy(id = "com.giffgaffmobile.controller:id/tv_nav_header_name")
    @iOSFindBy( xpath= "//XCUIElementTypeStaticText[@name=\"eyalyovel +447874990694”]")
    @FindBy( xpath= "//XCUIElementTypeStaticText[@name=\"eyalyovel +447874990694”]")
    private WebElement dropdownMenuMemberName;

    // Login
    public boolean isLogInButtonDisplayed(){
        return waitForElement(loginButton, 20).isDisplayed();
    }

    public void clickLogIn(){
        waitForElement(loginButton).click();
    }

    public void fillUsername(String username){
        waitForElement(usernameField, 10).sendKeys(username);
    }

    public void fillPassword(String password){
        waitForElement(passwordField).sendKeys(password);
    }

    public String getLoggedInMember(){
        String memberName = "";
        if(isAndroid()) {
            waitForElement(dropdownMenuButton).click();
            memberName = waitForElement(dropdownMenuMemberName).getText();
            return memberName;
        }
        else
            return myMember;
    }

    public boolean isDropDownMenuShown(){
        return waitForElement( dropdownMenuButton, 20).isDisplayed();
    }

}
