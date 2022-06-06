package com.neoquant.DaoImpl;

import java.util.List;

import com.neoquant.pojo.Employee;

public interface EmployeeDao {

	public boolean addEmployee(Employee emp);
	public boolean updateEmployee(Employee emp);
	public List<Employee> getAllEmployees();
	public Employee getEmployeeById(int id);
	public boolean deleteEmployee(int id);
	public Employee getMatchIdAndPasword(int employeeId, String password);
}
