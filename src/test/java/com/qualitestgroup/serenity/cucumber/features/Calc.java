package com.qualitestgroup.serenity.cucumber.features;

import net.serenitybdd.junit.runners.SerenityRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SerenityRunner.class)
public class Calc {

	WebDriver driver;

	@Before
	public void setUp() {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName", "707a6877");
		capabilities.setCapability(CapabilityType.VERSION, "6.0.1");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("appPackage", "com.sec.android.app.popupcalculator");
		capabilities.setCapability("appActivity", "com.sec.android.app.popupcalculator.Calculator");

		URL url = null;

		try {
			url = new URL("http://127.0.0.1:4723/wd/hub");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

		driver = new RemoteWebDriver(url, capabilities);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}

	@Test
	public void Sum() {
		List<WebElement> buttons = driver.findElements(By.xpath("//android.widget.Button"));
		WebElement clearButton = buttons.get(0);
		WebElement num2Button = buttons.get(14);
		WebElement plusSignButton = buttons.get(16);
		WebElement num5Button = buttons.get(10);
		WebElement equalSignButton = buttons.get(20);

		clearButton.click();
		num2Button.click();
		plusSignButton.click();
		num5Button.click();
		equalSignButton.click();

		String actualResult = driver.findElement(By.id("txtCalc")).getText();
		assertThat(actualResult).isEqualToIgnoringCase("7");
	}

	@After
	public void endTest() {
		driver.quit();
	}
}
