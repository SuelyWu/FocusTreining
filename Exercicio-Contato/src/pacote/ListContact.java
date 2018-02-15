package pacote;

import java.util.LinkedList;
import java.util.List;

public class ListContact {
	private List<Person> personList;
	
	public ListContact() {
		personList = new LinkedList<>();
		personList.add(new Person("Laura", 123456789));
		personList.add(new Person("Ana", 12345678));
		personList.add(new Person("Alice", 12345678));
		personList.add(new Person("Julia", 12345678));
		personList.add(new Person("Sofia", 12345678));
		personList.add(new Person("Larissa", 12345678));
		personList.add(new Person("Isabela", 12345678));
		personList.add(new Person("Maria", 12345678));
		personList.add(new Person("Mariana", 12345678));
		personList.add(new Person("Lara", 12345678));
		personList.add(new Person("Leticia", 12345678));
		personList.add(new Person("Valentina", 12345678));
		personList.add(new Person("Amanda", 12345678));
		personList.add(new Person("Luana", 12345678));
		personList.add(new Person("Yasmin", 12345678));
		personList.add(new Person("Sophia", 12345678));
		personList.add(new Person("Ana Maria", 8765321));
		personList.add(new Person("Bia", 123456677));
		personList.add(new Person("Carlos", 123456789));
		personList.add(new Person("Dani", 123456789));
		personList.add(new Person("Lais", 123456789));
		
	}

	public List<Person> getMatchingPerson(final String initial) {
		List<Person> matchingPerson = new LinkedList<>();
		for (Person p : personList){
			if (p.compareInitial(initial)){
				matchingPerson.add(p);
			}
		}

		return matchingPerson;
	}

}
