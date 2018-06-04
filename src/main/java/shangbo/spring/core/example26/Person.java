package shangbo.spring.core.example26;

public class Person {
	private String name = "Shangbo";
	private int age = 30;

	//
	// Setter
	//
	public void setName(String name) {
		this.name = name;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String toString() {
		return "[name=" + name + ", age=" + age + "]";
	}

}
