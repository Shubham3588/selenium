import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class windowHandleAssignment {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/");
		driver.findElement(By.xpath("//a[text()='Multiple Windows']")).click();
		driver.findElement(By.xpath("//*[@id='content']/div/a")).click();
		
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		String parentId = it.next();
		String childId = it.next();
		driver.switchTo().window(childId);
		String text = driver.findElement(By.xpath("//*[@class='example']/h3")).getText();
		System.out.println(text);
		driver.switchTo().window(parentId);
		String text2 = driver.findElement(By.xpath("//*[@id='content']/div/h3")).getText();
		System.out.println(text2);
		driver.quit();
		

	}

}
