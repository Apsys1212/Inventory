package one_to_one.bean;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="Personal_Details")
public class PersonalDetails {
	
	@Id
	@GeneratedValue
	private int id;
	
	@Column(name="Adress")
	private String address;
	
	@Column(name="Salary")
	private double salary;
	
	@OneToOne(mappedBy="personalDetails",fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	private Person person;

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public PersonalDetails(String address, double salary) {
		super();
		this.address = address;
		this.salary = salary;
	}

	public String getAddress() {
		return address;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public PersonalDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

}
