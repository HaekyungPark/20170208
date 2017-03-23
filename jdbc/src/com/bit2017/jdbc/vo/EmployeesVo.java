package com.bit2017.jdbc.vo;

public class EmployeesVo {
	private Long employeId;
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
	private String hireDate;
	private String jobTitle;
	private int salary;
	private float commissionPct;
	private String managerName;
	private String departmentName;
	
	
	public Long getEmployeId() {
		return employeId;
	}
	public void setEmployeId(Long employeId) {
		this.employeId = employeId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getHireDate() {
		return hireDate;
	}
	public void setHireDate(String hireDate) {
		this.hireDate = hireDate;
	}
	public String getJobTitle() {
		return jobTitle;
	}
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public float getCommissionPct() {
		return commissionPct;
	}
	public void setCommissionPct(float commissionPct) {
		this.commissionPct = commissionPct;
	}
	public String getManagerName() {
		return managerName;
	}
	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	@Override
	public String toString() {
		return "EmployeesVo [employeId=" + employeId + ", firstName=" + firstName + ", last_name=" + lastName
				+ ", email=" + email + ", phoneNumber=" + phoneNumber + ", hireDate=" + hireDate + ", jobTitle="
				+ jobTitle + ", salary=" + salary + ", commissionPct=" + commissionPct + ", managerName=" + managerName
				+ ", departmentName=" + departmentName + "]";
	}
}
