package com.neoquant.DaoImpl;

import java.util.List;

import com.neoquant.pojo.Employee;

public class EmployeeDaoImplMain {

	public static void main(String[] args) {
		
		EmployeeDaoImpl employee=new EmployeeDaoImpl();

//		boolean add= employee.addEmployee(new Employee("Prasad", "male", "Web Developer", "Wipro", "Bhandup", 102,"Prasad"));
//		System.out.println("Employee Added Successfully:"+add);
		
//		
//		boolean update=employee.updateEmployee(new Employee(7, "Prashay", "Male","Software Trainee", "TCS", "Bhandup",102,"Prasad"));
//		System.out.println("Employee updated Successfully:"+update);
//		
		List<Employee> empList=employee.getAllEmployees();
		for(Employee emp:empList) {
			System.out.println(emp.toString());
		}
		
//		boolean delete=employee.deleteEmployee(4);
//		System.out.println("Employee deleted Successfully:"+delete);
		
		Employee emp=employee.getEmployeeById(5);
		System.out.println("Get Employee By Id:"+emp);
		
		Employee empOne=employee.getMatchIdAndPasword(101, "Prasad");
		System.out.println(empOne);
	}
}
