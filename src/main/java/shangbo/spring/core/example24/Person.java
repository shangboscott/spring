package shangbo.spring.core.example24;

import java.util.List;

public class Person {
	private List<String> hobbies;

	//
	// Setter
	//
	public void setHobbies(List<String> hobbies) {
		this.hobbies = hobbies;
	}

	public String toString() {
		return hobbies.toString();
	}

}
