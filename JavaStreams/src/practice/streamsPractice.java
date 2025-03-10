package practice;

import java.util.ArrayList;

import org.testng.annotations.Test;

public class streamsPractice {
	@Test
	public void regular() {
		int count =0;
		ArrayList<String> names = new ArrayList<String>();
		names.add("Abhijeeet");
		names.add("Shubham");
		names.add("Ankit");
		names.add("Aarya");
		
		for(int i=0;i<names.size();i++) {
			String actual = names.get(i);
			if(actual.startsWith("A")) {
				count++;
			}
		}
		System.out.println(count);
	}


}
