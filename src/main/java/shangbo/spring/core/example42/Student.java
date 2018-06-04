package shangbo.spring.core.example42;

public class Student extends Person {
	private String school;

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}
	
	public String toString() {
		return "[school=" + name + ", age=" + age + ", school=" + school + "]";
	}
	
}
