import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Assignment1 {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//div[@class='form-group'] //input[@name='name']")).sendKeys("Shubham");
		driver.findElement(By.xpath("//div[@class='form-group'] //input[@name='email']")).sendKeys("Shubham@test.com");
		driver.findElement(By.cssSelector("input#exampleInputPassword1")).sendKeys("Shubham");
		driver.findElement(By.cssSelector("input#exampleCheck1")).click();
		WebElement dropdownElement = driver.findElement(By.cssSelector("select#exampleFormControlSelect1"));
		Select dropdown = new Select(dropdownElement);
		dropdown.selectByIndex(1);
		System.out.println(dropdown.getAllSelectedOptions());
		driver.findElement(By.cssSelector("input#inlineRadio1")).click();
		driver.findElement(By.xpath("//*[@name='bday']")).sendKeys("12-12-2025");
		driver.findElement(By.cssSelector("input.btn.btn-success")).click();
		String actualText = driver.findElement(By.cssSelector("div.alert.alert-success.alert-dismissible")).getText();
		String ExpectedText = "Success! The Form has been submitted successfully!.";
		Assert.assertEquals(actualText, ExpectedText);
		
		
		
	}

}
