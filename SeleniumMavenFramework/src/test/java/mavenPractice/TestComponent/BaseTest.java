package mavenPractice.TestComponent;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.github.bonigarcia.wdm.WebDriverManager;
import mavenPractice.pageobjects.loginPage;

public class BaseTest {
	public WebDriver driver;
	
	
	public WebDriver initializeDriver() throws IOException {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\mavenPractice\\resources\\GbalData.properties");
		prop.load(fis);
		String browserName =prop.getProperty("browser");
		if(browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			 driver = new ChromeDriver();
			
		}
		else if(browserName.equalsIgnoreCase("firefox")) {
			//Firefox
		}
		else if(browserName.equalsIgnoreCase("edge")) {
			//edge
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		return driver;
		
	}
	
	@BeforeMethod
	public loginPage launchApplication() throws IOException {
		driver = initializeDriver();
		loginPage loginpage = new loginPage(driver);
		loginpage.goTo();
		return loginpage;
		
		
		
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	public List<HashMap<String, String>> getJsonDataToMap() throws IOException {
		
		//read json to string
		String jsonContent = FileUtils.readFileToString(new File(System.getProperty("user.dir")+"src\\test\\java\\mavenPractice\\data\\PurchaseOrder.json"),StandardCharsets.UTF_8);
		
		//String to HashMap using Jackson Databinding
		
		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String,String>> data = mapper.readValue(jsonContent, new TypeReference<List<HashMap<String,String>>>(){
		
	});
		return data;

}

}
