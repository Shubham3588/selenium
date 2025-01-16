import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class LogicToSplitAString {

	public static void main(String[] args) throws InterruptedException {
		String name= "Shubham";
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
		String cred = driver.findElement(By.cssSelector("p.infoMsg")).getText();
		String[] str = cred.split("'");
		System.out.println(str[0]);
		String[] str2= str[1].split("'");
		System.out.println(str2[0]);
		driver.findElement(By.xpath("//button[contains(@class,'go')]")).click();
		driver.findElement(By.id("inputUsername")).sendKeys(name);
		driver.findElement(By.name("inputPassword")).sendKeys(str2[0]);
	    driver.findElement(By.className("signInBtn")).click();
	    Thread.sleep(3000);
	  String actual =  driver.findElement(By.tagName("p")).getText();
	  System.out.println(actual);
	  String expected = "You are successfully logged in.";
	   Assert.assertEquals(actual, expected);
	   String actual1 = driver.findElement(By.tagName("h2")).getText();
	   String expected1 = "Hello "+name +",";
	   System.out.println(expected1);
	   Assert.assertEquals(actual1, expected1);
	   driver.findElement(By.xpath("//*[text()='Log Out']"));
	   driver.quit();
		driver.quit();
		

	}

}
