package pack1;

import java.util.Date;

public class Employee
{
	private String name;
	private int id;
	public Address adress;
	public Employee(Address adress) 
	{
		this.adress = adress;
		System.out.println("constructor called");
	}
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public Address getAdress() {
		return adress;
	}


	public void setAdress(Address adress) {
		this.adress = adress;
		System.out.println("using Setter");
	}
	@Override
	public String toString() {
		return "Employee [name=" + name + ", id=" + id + ", adress=" + adress + "]";
	}

}
