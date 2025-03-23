package mavenPractice.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import dev.failsafe.internal.util.Assert;
import mavenPractice.AbstractComponents.AbstractComponent;

public class ordersPage extends AbstractComponent{
	WebDriver driver;

	public ordersPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="(//*[text()='Delete'])[2]")
	WebElement clickDelete;
	
	@FindBy(xpath="//div[@class='mt-4 ng-star-inserted']")
	WebElement validateSuccessMessage;
	
	public void clickDelete() {
		waitForElementToAppear(By.xpath("//*[text()='Delete']"));
		clickDelete.click();
		System.out.println("Clicked delete button");
	}
	
	public String validateMessage() {
		String actual = validateSuccessMessage.getText();
		return actual;
		
	}
	
	

	
	

}
