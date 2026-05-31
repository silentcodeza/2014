
public class Person {
	private String surname;
	private String firstName;
	private int age;
	
	public Person(String surname, String firstName, int age) {
		super();
		this.surname = surname;
		this.firstName = firstName;
		this.age = age;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Person [surname=" + surname + ", firstName=" + firstName
				+ ", age=" + age + "]\n";
	}
	
	
}
