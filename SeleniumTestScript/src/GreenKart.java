import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GreenKart {

	public static void main(String[] args) throws InterruptedException {
		int j=0;
		String[] itemRequired = {"Brocolli","Cucumber","Beetroot"};
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		driver.manage().window().maximize();
		Thread.sleep(3000);
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
	}
}
