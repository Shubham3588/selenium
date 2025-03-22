package mavenPractice.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import mavenPractice.AbstractComponents.AbstractComponent;

public class cartPage extends AbstractComponent{
	WebDriver driver;
	
	public cartPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath ="//*[text()='Checkout']")
	WebElement checkoutButton;
	
	public void clickCheckoutBButton() {
		checkoutButton.click();
	}
	





}
