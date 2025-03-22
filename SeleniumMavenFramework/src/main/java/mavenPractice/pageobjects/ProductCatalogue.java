package mavenPractice.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import mavenPractice.AbstractComponents.AbstractComponent;

public class ProductCatalogue extends AbstractComponent{
WebDriver driver;
	
	public ProductCatalogue(WebDriver driver) {
		super(driver);  //We need to use super keyword from all child
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//h5/b")
	List<WebElement> lst; 
	
	@FindBy(xpath="//span[@class='ng-star-inserted']")
	List<WebElement> countryLst;
	
	
	public List<WebElement> getProductList() {
		waitForElementToAppear(By.xpath("//h5/b"));
		return lst;
	}
	
	public void getProductByName(String productName) throws InterruptedException {
		for(WebElement itemList:getProductList()) {
			System.out.println("In for loop");
			String item = itemList.getText();
			System.out.println(item);
			if(productName.equals(item)) {
				System.out.println("In if loop");
				driver.findElement(By.xpath("//*[@class='btn w-10 rounded']")).click();
				waitForElementToAppear(By.cssSelector("#toast-container"));
				waitForElementToAppear(By.cssSelector(".ng-animating"));
				waitForElementToAppear(By.xpath("//ul/li[4]/button"));
				Thread.sleep(3000);
			}
		}
	}
	
	
	public void selectCountry(String countryName) {
		for(WebElement country:countryLst) {
			String getCountryName = country.getText();
			if(getCountryName.equals(countryName)) {
				country.click();
				break;
			}
		}
		
	}
	
	


	
	


}
