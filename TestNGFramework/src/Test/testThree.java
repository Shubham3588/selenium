package Test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class testThree {
	
	@Test
	public void carLoanWebLogin() {
		System.out.println("carLoan Web Login Test");
	}
	
	@Test
	public void carLoanMobileLogin() {
		System.out.println("carLoan Mobile Login Test");
	}
	
	@BeforeTest
	public void prerequisite() {
		System.out.println("This method will execute first ");
	}
	
	@AfterTest
	public void endExecution() {
		System.out.println("This method will execute Last");
	}
	
	@BeforeSuite
	public void loadEnvironment() {
		System.out.println("I am before suite");
	}
	
	@AfterSuite
	public void endEnvironmennt() {
		System.out.println("I am after suite");
	}
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("********************************I am before Method******************************");
	}
	
	@AfterMethod
	public void afterMethod() {
		System.out.println("*********************************I am after Method*********************************");
	}
	@BeforeClass
	public void beforeClass() {
		System.out.println("********************************I am before Class******************************");
	}
	
	@AfterClass
	public void afterClass() {
		System.out.println("*********************************I am after Class*********************************");
	}
	@Test(groups= {"smoke"})
	public void carLoanApiLogin() {
		System.out.println("carLoan API Login Test");
	}

}
