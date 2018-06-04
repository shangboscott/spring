package shangbo.spring.core.example27;

public class Person {
	private Address address = new Address();

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String toString() {
		return "[address=" + address + "]";
	}

}
