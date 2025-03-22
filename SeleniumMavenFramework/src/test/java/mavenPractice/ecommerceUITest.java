package mavenPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import mavenPractice.TestComponent.BaseTest;
import mavenPractice.pageobjects.ProductCatalogue;
import mavenPractice.pageobjects.cartPage;
import mavenPractice.pageobjects.loginPage;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ecommerceUITest extends BaseTest{
	
@Test
public void createOrder() throws IOException, InterruptedException {


		String productName = "ZARA COAT 3";
		String countryName= "India";
		loginPage loginpage = new loginPage(driver);		
		loginpage.loginApp("version@gmail.com", "Test@123");
		
		ProductCatalogue productcatalogue = new ProductCatalogue(driver);
		List<WebElement>lst= productcatalogue.getProductList();
		productcatalogue.getProductByName(productName);
		productcatalogue.goToCartPage();
		cartPage cartpage = new cartPage(driver);
		cartpage.clickCheckoutBButton();
		
		driver.findElement(By.xpath("(//input[@class='input txt'])[1]")).sendKeys("778");
		driver.findElement(By.xpath("(//input[@class='input txt'])[2]")).sendKeys("Shubham");
		driver.findElement(By.xpath("//*[text()='Place Order ']")).click();
		driver.findElement(By.xpath("//*[@placeholder='Select Country']")).sendKeys("Ind");
		//List<WebElement> countryList = driver.findElements(By.xpath("//span[@class='ng-star-inserted']"));
		productcatalogue.selectCountry(countryName);
		driver.findElement(By.xpath("//*[text()='Place Order ']")).click();
		String actual = driver.findElement(By.xpath("//*[@class='hero-primary']")).getText();
		String expected = "THANKYOU FOR THE ORDER.";
		Assert.assertEquals(actual, expected);
		
	


	}

@Test
public void validateErrorPopup() {
	Assert.assertTrue(false);
}
}


