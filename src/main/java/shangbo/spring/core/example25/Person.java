package shangbo.spring.core.example25;

import java.util.Set;

public class Person {
	private Set<String> hobbies;

	//
	// Setter
	//
	public String toString() {
		return hobbies.toString();
	}

	public void setHobbies(Set<String> hobbies) {
		this.hobbies = hobbies;
	}

}
