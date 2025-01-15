import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Selenium {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.manage().window().maximize();
		driver.findElement(By.id("inputUsername")).sendKeys("rahul");
		driver.findElement(By.name("inputPassword")).sendKeys("hello123");
		driver.findElement(By.className("signInBtn")).click();
		String errorMessage = driver.findElement(By.cssSelector("p.error")).getText();
		System.out.println(errorMessage);
		driver.findElement(By.xpath("//*[text()=\"Forgot your password?\"]")).click();
		driver.findElement(By.cssSelector("input[placeholder='Name']")).sendKeys("Shubham");
		driver.findElement(By.cssSelector("input[placeholder='Name']")).sendKeys("Shubham@test.com");  //CSS Selector
		driver.findElement(By.cssSelector("input[type='text']:nth-child(4)")).sendKeys("78667676");  //CSS Selector indexing
		driver.findElement(By.cssSelector("button.reset-pwd-btn")).click();
		String cred = driver.findElement(By.xpath("//form/p")).getText();
		System.out.println(cred);
		driver.quit();
		
		
		

	
		 
	

	}

}
