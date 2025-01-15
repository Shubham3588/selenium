import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class locatorsOne {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.manage().window().maximize();
		driver.findElement(By.id("inputUsername")).sendKeys("rahul");
		driver.findElement(By.name("inputPassword")).sendKeys("hello123");
	WebElement el = 	driver.findElement(By.className("signInBtn"));
	el.click();
		String errorMessage = driver.findElement(By.cssSelector("p.error")).getText();
		System.out.println(errorMessage);
		driver.findElement(By.xpath("//*[text()=\"Forgot your password?\"]")).click();
		driver.findElement(By.cssSelector("input[placeholder='Name']")).sendKeys("Shubham");
		driver.findElement(By.cssSelector("input[placeholder='Name']")).sendKeys("Shubham@test.com");  //CSS Selector
		driver.findElement(By.cssSelector("input[type='text']:nth-child(4)")).sendKeys("78667676");  //CSS Selector indexing
		driver.findElement(By.cssSelector("button.reset-pwd-btn")).click();
		String cred = driver.findElement(By.xpath("//form/p")).getText();  //Parent child traverse
		System.out.println(cred);
		driver.findElement(By.xpath("//button[contains(@class,'go')]")).click();  //Contains
		driver.findElement(By.cssSelector("input#inputUsername")).sendKeys("Shubham");
		driver.findElement(By.xpath("//*[@name=\"inputPassword\"]")).sendKeys("rahulshettyacademy");
		driver.findElement(By.cssSelector("input#chkboxOne")).click();
		driver.findElement(By.cssSelector("input#chkboxTwo")).click();
		el.click();
		
		driver.quit();
		
		
		

	
		 
	

	}

}
