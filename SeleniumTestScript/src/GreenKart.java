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

public class GreenKart {
	int j=0;
	public static void main(String[] args) throws InterruptedException {
		
		String[] itemRequired = {"Brocolli","Cucumber","Beetroot"};


		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		GreenKart gt = new GreenKart();
		gt.selectItem(driver,itemRequired);

		}
	
	public void selectItem(WebDriver driver,String[] itemRequired) throws InterruptedException {
		
		List<WebElement> itemAvailable = driver.findElements(By.cssSelector("h4.product-name"));
		int size = itemAvailable.size();
		System.out.println(size);
		for(int i=0;i<=itemAvailable.size()-1;i++) {
			String[] item = itemAvailable.get(i).getText().split("-");
			String trimmedItem = item[0].trim();
			List itemNeededList = Arrays.asList(itemRequired);
			if(itemNeededList.contains(trimmedItem)) {
				System.out.println(trimmedItem);
				
				j++;
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				if(j==itemRequired.length) {
					break;
				}
			}
		
			

		

	}
		driver.findElement(By.cssSelector("a.cart-icon")).click();
		driver.findElement(By.xpath("//div[@class='action-block']/button[text()='PROCEED TO CHECKOUT']")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");
		driver.findElement(By.cssSelector("button.promoBtn")).click();
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));
		
		String actual = driver.findElement(By.cssSelector("span.promoInfo")).getText();
		String expected = "Code applied ..!";
		Assert.assertEquals(actual, expected);
		driver.findElement(By.xpath("//*[text()='Place Order']")).click();
		
		Select dropdown = new Select(driver.findElement(By.xpath("//div[@class='products']/div/div/select")));
		dropdown.selectByIndex(2);
		driver.findElement(By.cssSelector("input.chkAgree")).click();
		driver.findElement(By.xpath("//*[text()='Proceed']")).click();
		driver.quit();
	}
	
}
