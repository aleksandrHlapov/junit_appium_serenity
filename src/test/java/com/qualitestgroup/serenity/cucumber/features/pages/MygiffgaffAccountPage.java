package com.qualitestgroup.serenity.cucumber.features.pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MygiffgaffAccountPage extends BasePage {

    @AndroidFindBy(id = "com.giffgaffmobile.controller:id/list_item_section_text")
    @iOSFindBy(xpath="//XCUIElementTypeStaticText[@name=\" My goodybags”]")
    @FindBy(xpath="//XCUIElementTypeStaticText[@name=\" My goodybags”]")
    private List<WebElement> listItemSectionText;

    public String getTextForSection(int index){
        waitABit(8000);
        return getDriver().findElement(By.xpath("//XCUIElementTypeStaticText[@name=\" My goodybags\"]")).getText();

    }
}
