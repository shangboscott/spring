package shangbo.spring.core.example20;

public class Person {
	private String name;
	private int age;

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
