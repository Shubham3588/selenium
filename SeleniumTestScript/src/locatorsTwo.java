import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class locatorsTwo {

	public static void main(String[] args) throws InterruptedException {
		String name= "Shubham";
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.manage().window().maximize();
		driver.findElement(By.id("inputUsername")).sendKeys(name);
		driver.findElement(By.name("inputPassword")).sendKeys("rahulshettyacademy");
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
	   driver.quit();

	}

}
