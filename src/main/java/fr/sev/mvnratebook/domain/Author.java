package fr.sev.mvnratebook.domain;

public class Author {

	private int id;
	private String name;
	private String firstname;
	private String firstLanguage;
	private int birthYear;
	
	public Author() {
		super();
	}
	
	public Author(String name, String firstname, String firstLanguage, int birthYear) {
		super();
		this.name = name;
		this.firstname = firstname;
		this.firstLanguage = firstLanguage;
		this.birthYear = birthYear;
	}

	public Author(String name, String firstname, int birthYear) {
		super();
		this.name = name;
		this.firstname = firstname;
		this.birthYear = birthYear;
	}

	public Author(int id, String name, String firstname, int birthYear) {
		super();
		this.id = id;
		this.name = name;
		this.firstname = firstname;
		this.birthYear = birthYear;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getFirstLanguage() {
		return firstLanguage;
	}
	
	public void setFirstLanguage(String firstLanguage) {
		this.firstLanguage = firstLanguage;
	}
	
	public int getBirthYear() {
		return birthYear;
	}

	public void setBirthYear(int birthYear) {
		this.birthYear = birthYear;
	}

	@Override
	public String toString() {
		return "Author [id=" + id + ", name=" + name + ", firstname=" + firstname + ", firstLanguage=" + firstLanguage
				+ ", birthYear=" + birthYear + "]";
	}
	
}
