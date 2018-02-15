package pacote;

public class Person {
	private final String name;
	private final int telephone;

	public Person(String name, int telephone) {
		this.name = name.toUpperCase();
		this.telephone = telephone;
	}
	
	public boolean compareInitial(String initial) {
		return name.startsWith(initial.toUpperCase());
	}
	
	public String toString() {
		return "Name: " + this.name + ", Tel: " + this.telephone;
 	}
	
}
