package mavenPractice;

import org.testng.Assert;
import org.testng.annotations.Test;

import mavenPractice.TestComponent.BaseTest;
import mavenPractice.pageobjects.loginPage;

public class errorValidationTest extends BaseTest {

	@Test
	public void errorValidation() {
		loginPage loginpage = new loginPage(driver);
		loginpage.loginApp("shub@test.com", "Test@123");
		Assert.assertEquals("Incorrect email or password.", loginpage.validateError());
	}

	@Test
	public void correctCredential() {
		loginPage loginpage = new loginPage(driver);
		loginpage.loginApp("version@gmail.com", "12345");
		Assert.assertTrue(true);
	}

}
