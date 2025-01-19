import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutosuggestiveDropdown {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.manage().window().maximize();
		driver.findElement(By.id("autosuggest")).click();
		driver.findElement(By.id("autosuggest")).sendKeys("Ind");
		Thread.sleep(2000);
		List<WebElement> options = driver.findElements(By.xpath("//*[@class='ui-menu-item'] //a"));
	//	List<WebElement> elements = driver.findElements(By.class("ui-menu-item"));
		int elementsLength = options.size();
		System.out.println(elementsLength);
/*		for(int i=0;i<elementsLength;i++) {
			if(options.get(i).getText().equalsIgnoreCase("India")) {
				options.get(i).click();
				break;
			}
		
		}*/
		
		for(WebElement option : options) {
			if(option.getText().equalsIgnoreCase("India"))
			{
				option.click();
			}
		}

	}

}
