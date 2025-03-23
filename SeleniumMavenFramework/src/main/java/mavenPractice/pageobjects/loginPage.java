package mavenPractice.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import mavenPractice.AbstractComponents.AbstractComponent;

public class loginPage extends AbstractComponent{
	
	WebDriver driver;
	
	public loginPage(WebDriver driver) {
		super(driver);  //Used to provide the access of driver to AbstractComponent(Parent)
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	

	//public WebElement  email = driver.findElement(By.id("userEmail"));
	
	@FindBy(id="userEmail")
	WebElement userEmail;
	
	@FindBy(id="userPassword")
	WebElement userPassword;
	
	@FindBy(id="login")
	WebElement login;
	
	@FindBy(xpath ="//div[@id='toast-container']")
	WebElement errorMessage;
	
	public void loginApp(String email,String password) {
		userEmail.sendKeys(email);
		userPassword.sendKeys(password);
		login.click();		
	}
	
	public String validateError() {
		
		String actualMesage = errorMessage.getText();
		System.out.println(actualMesage);
		return actualMesage;
		
		
	}
	public void goTo() {
		driver.get("https://rahulshettyacademy.com/client/");
	}



}
