package com.qualitestgroup.serenity.cucumber.features.pages;

import net.serenitybdd.core.SerenitySystemProperties;
import net.thucydides.core.ThucydidesSystemProperty;
import net.thucydides.core.pages.PageObject;
import net.thucydides.core.util.EnvironmentVariables;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BasePage extends PageObject {
    public static final Logger LOGGER = LoggerFactory.getLogger(BasePage.class);
    private static boolean isIOS;
    private static boolean isAndroid;
    public String myMember = "eyalyovel";

    public static void setAndroid(boolean android){
        isAndroid = android;
    }

    public static boolean isAndroid(){
        return isAndroid;
    }

    public static void setIOS(boolean iOS){
        isIOS = iOS;
    }

    public static boolean isIOS(){
        return isIOS;
    }

    //general
    public WebElement waitForElement(WebElement element){
        return waitForElement(element, 5);
    }
    public WebElement waitForElement(WebElement element, int seconds){
        WebDriverWait wait = new WebDriverWait(getDriver(), seconds);
        wait.until(ExpectedConditions.visibilityOf(element));
        return element;
    }
}
