package Test;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class testTwo {
	
	@Test(enabled=true)
	public void carLoan() {
		System.out.println("Car Loan");
	}
	@Test(groups= {"smoke"})
	public void groupTest() {
		System.out.println("I am from group test");
	}
	@Test(dependsOnMethods= {"carLoan"})
	public void adependentTest() {
		System.out.println("I am dependent on car loan");
	}
	
	@DataProvider
	public void getData() {
		Object[][] data = new Object[3][2];
		data[0][0]= "un1";
		data[0][1]="pwd1";
		data[1][0]= "un2";
		data[1][1]="pwd2";
		data[2][0]= "un3";
		data[2][1]="pwd3";
	}


}
