import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class EndToEndTest {

	public static void main(String[] args) throws InterruptedException {
		String orderItem = "Cucumber";
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		driver.manage().window().maximize();
		List<WebElement> itemList = driver.findElements(By.xpath("//*[@class='product-name']"));
		//System.out.println(itemList);
		for(WebElement item : itemList) {
			String itemText = item.getText();
			String[] name = itemText.split("-");
			String trimmedName = name[0].trim();
		//	System.out.println(trimmedName);
		//	System.out.println(name[0]);
		//	System.out.println(item.getText());
			if(trimmedName.equalsIgnoreCase(orderItem)) {
			//	item.click();
			//	System.out.println(trimmedName);
			//	driver.findElement(By.xpath("//*[@class='product'] //button")).click();
				String dynamicXPath = "//*[@class='product' and .//*[contains(text(), '" + trimmedName + "')]]//button";
				driver.findElement(By.xpath(dynamicXPath)).click();
			Thread.sleep(4000);
				//break;
			}
		}
		driver.quit();
		

	}

}
