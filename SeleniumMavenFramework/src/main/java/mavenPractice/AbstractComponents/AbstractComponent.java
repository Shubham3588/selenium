package mavenPractice.AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractComponent {
	
	@FindBy(css="[routerlink*='cart']")
	WebElement clickOnCart;
	
	WebDriver driver;
	public AbstractComponent(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public void waitForElementToAppear(By findBy) {
		WebDriverWait wt = new WebDriverWait(driver,Duration.ofSeconds(10));
		wt.until(ExpectedConditions.visibilityOfElementLocated(findBy));
		
	}
	
	public void goToCartPage() {
		clickOnCart.click();
	}

}
