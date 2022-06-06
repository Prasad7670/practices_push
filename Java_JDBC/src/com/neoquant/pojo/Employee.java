
package com.neoquant.pojo;

public class Employee {

	private int id;
	private String name;
	private String gender;
	private String occupation;
	private String companyName;
	private String address;
	private int employeeId;
	private String password;
	
	public Employee() {
		super();
	}

	public Employee(int id, String name, String gender, String occupation, String companyName, String address,
			int employeeId, String password) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.occupation = occupation;
		this.companyName = companyName;
		this.address = address;
		this.employeeId = employeeId;
		this.password = password;
	}
	
	public Employee(String name, String gender, String occupation, String companyName, String address, int employeeId,
			String password) {
		super();
		this.name = name;
		this.gender = gender;
		this.occupation = occupation;
		this.companyName = companyName;
		this.address = address;
		this.employeeId = employeeId;
		this.password = password;
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
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getOccupation() {
		return occupation;
	}
	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", gender=" + gender + ", occupation=" + occupation
				+ ", companyName=" + companyName + ", address=" + address + ", employeeId=" + employeeId + ", password="
				+ password + "]";
	}		
}
