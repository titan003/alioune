package alioune;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
	
	public static void main(String[] args) {
		Person p1 =  new Person("BEYE", "Alioune", true, false);
		Person p2 =  new Person("sldfiu", "dlfkj", true, true);
		Person p3 =  new Person("vnso", "dlfkjqs", false, false);
		Person p4 =  new Person("BEYE", "vclj", true, true);
		Person p5 =  new Person("sfj", "wvlwkj", false, false);
		Person p6 =  new Person("vosp", "dlfkjm", false, true);
		Person p7 =  new Person("BEYE", "Alioune", true, true);
		Person p8 =  null;


		List<Person> listPerson = Arrays.asList(p1,p2,p3,p4,p5,p6,p7,p8);
		
		listPerson.sort(Comparator.nullsFirst(
		         Comparator.comparing(Person::isGood).thenComparing(Person::isGentille, Comparator.reverseOrder())));
		listPerson.stream().forEach(p->System.out.println(p));
	}
	
	

}
