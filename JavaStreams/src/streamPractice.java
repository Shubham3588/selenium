import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.annotations.Test;

public class streamPractice {
	@Test(enabled=false)
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
	@Test(enabled=false)
	public void streamFilter() {
		ArrayList<String> names = new ArrayList<String>();
		names.add("Abhijeeet");
		names.add("Shubham");
		names.add("Ankit");
		names.add("Aarya");
		
		Long c=names.stream().filter(s->s.startsWith("A")).count();
	//	 System.out.println(c);
		 
		Long d =  Stream.of("Shubham","Ankit","Aarya","Aadam","Rahul").filter(s->s.startsWith("A")).count();
	//	System.out.println(d);
		
		//print all names of arraylist which is >4
		
	//	names.stream().filter(s->s.length()>4).forEach(s->System.out.println(s));
		
	//	names.stream().filter(s->s.length()>4).limit(1).forEach(s->System.out.println(s));
		
		
	}
	
	@Test(enabled = false)
	public void streamMap() {
		//Print names of length>4 with uppercase and last letter as a
		//Stream.of("Abhijeet","Alekhya","Ram","Raja").filter(s->s.endsWith("a")).forEach(s->System.out.println(s.toUpperCase()));
		//Stream.of("Abhijeet","Alekhya","Ram","Raja").filter(s->s.endsWith("a")).map(s->s.toUpperCase()).forEach(s->System.out.println(s));
		
		//Print names which have first letter aas a with uppercase and sorted
		List<String> names = Arrays.asList("Shubham","Ankit","Aarya","Azdam","Rahul");
		names.stream().filter(s->s.startsWith("A")).sorted().map(s->s.toUpperCase()).forEach(s->System.out.println(s));
		
	}
	
	//Merge two array
	@Test(enabled = false)
	public void mergeTwoArray() {
		ArrayList<String> names = new ArrayList<String>();
		names.add("Sujeet");
		names.add("Prakash");
		names.add("Anu");
		names.add("Abhay");
		
		List<String> names1 = Arrays.asList("Shubham","Ankit","Aarya","Azdam","Rahul");
		names1.stream().filter(s->s.startsWith("A")).sorted().map(s->s.toUpperCase()).forEach(s->System.out.println(s));
		
		Stream<String> newStream = Stream.concat(names.stream(), names1.stream());
		newStream.sorted().forEach(s->System.out.println(s));
		
		
	}
	
	//Take the output and make it list
	@Test(enabled = false)
	public void streamCollect() {
		List<String> ls =Stream.of("Shubham","Ankit","Aarya","Aadam","Rahul").filter(s->s.endsWith("a")).map(s->s.toUpperCase()).collect(Collectors.toList());
		System.out.println(ls.get(0));
		
	}
	
	//Print unique numbers
	
	
	@Test
	public void uniqueNumber() {
		List<Integer>ls = Arrays.asList(3,4,6,7,3,5,9,2);
		ls.stream().distinct().forEach(s->System.out.println(s));
	}
	
	
	


}
