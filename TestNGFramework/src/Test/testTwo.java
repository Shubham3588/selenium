package Test;

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


}
