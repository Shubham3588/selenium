package mavenPractice;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class ecommerceUITest {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		String requiredItem = "ZARA COAT 3";
		driver.get("https://rahulshettyacademy.com/client/");
	driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.id("userEmail")).sendKeys("version@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Test@123");
		driver.findElement(By.id("login")).click();
		List<WebElement> lst = driver.findElements(By.xpath("//h5/b"));
		
		for(WebElement itemList:lst) {
			System.out.println("In for loop");
			String item = itemList.getText();
			System.out.println(item);
			if(requiredItem.equals(item)) {
				System.out.println("In if loop");
				driver.findElement(By.xpath("//*[@class='btn w-10 rounded']")).click();
			}
		}
		WebDriverWait wt = new WebDriverWait(driver,Duration.ofSeconds(10));
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
		wt.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ng-animating")));
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul/li[4]/button")));
		driver.findElement(By.xpath("//ul/li[4]/button")).click();
		driver.findElement(By.xpath("//*[text()='Checkout']")).click();
		driver.findElement(By.xpath("(//input[@class='input txt'])[1]")).sendKeys("778");
		driver.findElement(By.xpath("(//input[@class='input txt'])[2]")).sendKeys("Shubham");
		driver.findElement(By.xpath("//*[text()='Place Order ']")).click();
		driver.findElement(By.xpath("//*[@placeholder='Select Country']")).sendKeys("Ind");
		List<WebElement> countryList = driver.findElements(By.xpath("//span[@class='ng-star-inserted']"));
		for(WebElement country:countryList) {
			String countryName = country.getText();
			if(countryName.equals("India")) {
				country.click();
				break;
			}
		}
		driver.findElement(By.xpath("//*[text()='Place Order ']")).click();
		String actual = driver.findElement(By.xpath("//*[@class='hero-primary']")).getText();
		String expected = "THANKYOU FOR THE ORDER.";
		Assert.assertEquals(actual, expected);
	


	}

}
