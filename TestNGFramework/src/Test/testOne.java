package Test;

import org.testng.annotations.Test;

public class testOne {
	@Test(groups= {"smoke"})
	public void test() {
		System.out.println("Hello");
	}

}
