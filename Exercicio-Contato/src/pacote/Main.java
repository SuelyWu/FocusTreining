package pacote;

import java.util.List;

public class Main {

	public static void main(String[] args) {
		ListContact c = new ListContact();
		searchPersonStartWith(c, "m");
	}

	public static void searchPersonStartWith(ListContact c, String initial){
		List list = c.getMatchingPerson(initial);
		list.forEach(System.out::println);
	}

}
