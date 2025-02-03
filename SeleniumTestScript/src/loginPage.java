import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class loginPage {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		String[] itemRequired = {"iphone X","Samsung Note 8","Motorolla","Nokia Edge"};
		
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		driver.findElement(By.cssSelector("input#username")).sendKeys("rahulshettyacademy");
		driver.findElement(By.cssSelector("input#password")).sendKeys("learning");
		driver.findElement(By.xpath("//*[@class='form-check-inline']/label[2]")).click();
		WebDriverWait wt = new WebDriverWait(driver,Duration.ofSeconds(5));
		wt.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("button#okayBtn"))));
		driver.findElement(By.cssSelector("button#okayBtn")).click();
		
		Select sl = new Select(driver.findElement(By.cssSelector("select.form-control")));
		sl.selectByValue("teach");
		driver.findElement(By.cssSelector("input#terms")).click();
		driver.findElement(By.cssSelector("input#signInBtn")).click();
		wt.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(),'Shop Name')]")));
		List itemNeeded = Arrays.asList(itemRequired);
		List<WebElement> product = driver.findElements(By.cssSelector("h4.card-title"));
		int sz = product.size();		
		for(int i=0;i<product.size();i++) {		
			if(itemNeeded.contains(product.get(i).getText())) {				
				driver.findElements(By.xpath("//*[text()='Add ']")).get(i).click();			
			}	
	}		
		driver.findElement(By.xpath("//*[@id='navbarResponsive']/ul/li/a")).click();
		driver.findElement(By.xpath("//*[@class='btn btn-success']")).click();
		driver.findElement(By.id("country")).sendKeys("Ind");
		wt.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class='suggestions']")));
		List<WebElement> countryName = driver.findElements(By.xpath("//*[@class='suggestions']/ul"));
		for(int i=0;i<countryName.size();i++) {
			if(countryName.get(i).getText().contains("India")) {
				countryName.get(i).click();
			break;
			}
		}
	//	wt.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(@class,'checkbox')]/input")));
		//driver.findElement(By.id("checkbox2")).click();
		driver.findElement(By.xpath("//div[@class='checkbox checkbox-primary']")).click();
		driver.findElement(By.xpath("//*[@type='submit']")).click();	
		String expected = "Success! Thank you! Your order will be delivered in next few weeks :-).";
		String actual = driver.findElement(By.xpath("//*[@class='alert alert-success alert-dismissible']")).getText();
		Assert.assertEquals(actual, expected);
		driver.quit();
	}
	
}
