package com.neoquant.DaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.neoquant.dbutil.Constants;
import com.neoquant.dbutil.DataBaseConnection;
import com.neoquant.pojo.Employee;

public class EmployeeDaoImpl implements EmployeeDao{

	private static final String ADD_EMP = "INSERT INTO employee(name,gender,occupation,company_name,address,employeeid,password)values(?,?,?,?,?,?,?)";
	private static final String UPDATE_EMP = "UPDATE employee set name=?,gender=?,occupation=?,company_name=?,address=?,employeeid=?,password=? where id=?";
	private static final String GET_ALL_EMP = "SELECT *from employee";
	private static final String DROP_EMP = "DELETE FROM employee where id=?";
	private static final String GET_EMP_BY_ID = "SELECT *from employee where id=?";
	private static final String GET_EMP_ID_PASS = "SELECT *from employee where employeeid=? and password=?";
	
	@Override
	public boolean addEmployee(Employee emp) {
		Connection conn=null;
		PreparedStatement pre=null;
		int pos=0;
		int result=0;
		boolean saveStatus=false;
		
		try {
			conn=DataBaseConnection.establishedConnection();
			pre=conn.prepareStatement(ADD_EMP);
			pre.setString(++pos, emp.getName());
			pre.setString(++pos, emp.getGender());
			pre.setString(++pos, emp.getOccupation());
			pre.setString(++pos, emp.getCompanyName());
			pre.setString(++pos, emp.getAddress());
			pre.setInt(++pos, emp.getEmployeeId());
			pre.setString(++pos, emp.getPassword());
			result=pre.executeUpdate();
			if(result>0) {
				saveStatus=true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return saveStatus;
	}

	@Override
	public boolean updateEmployee(Employee emp) {
		
		Connection conn=null;
		PreparedStatement pre=null;
		int pos=0;
		int result=0;
		boolean saveStatus=false;
		
		try {
			conn=DataBaseConnection.establishedConnection();
			pre=conn.prepareStatement(UPDATE_EMP);
			pre.setString(++pos, emp.getName());
			pre.setString(++pos, emp.getGender());
			pre.setString(++pos, emp.getOccupation());
			pre.setString(++pos, emp.getCompanyName());
			pre.setString(++pos, emp.getAddress());
			pre.setInt(++pos, emp.getEmployeeId());
			pre.setString(++pos, emp.getPassword());
			pre.setInt(++pos, emp.getId());
			result=pre.executeUpdate();
			if(result>0) {
				saveStatus=true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return saveStatus;
	}

	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> employeeList=new ArrayList<Employee>();
		
		Connection conn=null;
		PreparedStatement pre=null;
		ResultSet rs=null;
		
		try {
			conn = DataBaseConnection.establishedConnection();
			pre=conn.prepareStatement(GET_ALL_EMP);
			rs=pre.executeQuery();
			
			while(rs.next()) {
				Employee emp=new Employee(rs.getInt(Constants.ID), rs.getString(Constants.NAME), rs.getString(Constants.GENDER),
						rs.getString(Constants.OCCUPATION), rs.getString(Constants.COMPANY_NAME), rs.getString(Constants.ADDRESS),
						rs.getInt(Constants.EMPLOYEEID), rs.getString(Constants.PASSWORD));
				employeeList.add(emp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return employeeList;
	}

	@Override
	public boolean deleteEmployee(int id) {
		
		Connection conn=null;
		PreparedStatement pre=null;
		int pos=0;
		int result=0;
		boolean saveStatus=false;
		
		try {
			conn = DataBaseConnection.establishedConnection();
			pre=conn.prepareStatement(DROP_EMP);
			pre.setInt(++pos, id);
			result=pre.executeUpdate();
			if(result>0) {
				saveStatus=true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return saveStatus;
	}

	@Override
	public Employee getEmployeeById(int id) {
		
		Connection conn=null;
		PreparedStatement pre=null;
		int pos=0;
		ResultSet rs=null;
		Employee emp=null;
		
		try {
			conn=DataBaseConnection.establishedConnection();
			pre=conn.prepareStatement(GET_EMP_BY_ID);
			pre.setInt(++pos, id);
			rs=pre.executeQuery();
			
			if(rs.next()) {
				emp=new Employee();
				emp.setName(rs.getString(Constants.NAME));
				emp.setGender(rs.getString(Constants.GENDER));
				emp.setOccupation(rs.getString(Constants.OCCUPATION));
				emp.setCompanyName(rs.getString(Constants.COMPANY_NAME));
				emp.setAddress(rs.getString(Constants.ADDRESS));
				emp.setEmployeeId(rs.getInt(Constants.EMPLOYEEID));
				emp.setPassword(rs.getString(Constants.PASSWORD));
				emp.setId(rs.getInt(Constants.ID));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return emp;
	}

	@Override
	public Employee getMatchIdAndPasword(int employeeId, String password) {
		
		Connection conn=null;
		PreparedStatement pre=null;
		int pos=0;
		ResultSet rs=null;
		Employee emp=null;
		
		try {
			conn = DataBaseConnection.establishedConnection();
			pre=conn.prepareStatement(GET_EMP_ID_PASS);
			pre.setInt(++pos, employeeId);
			pre.setString(++pos, password);
			
			rs=pre.executeQuery();
			
			if(rs.next()) {
				emp=new Employee();
				emp.setId(rs.getInt(Constants.ID));
				emp.setName(rs.getString(Constants.NAME));
				emp.setGender(rs.getString(Constants.GENDER));
				emp.setOccupation(rs.getString(Constants.OCCUPATION));
				emp.setCompanyName(rs.getString(Constants.COMPANY_NAME));
				emp.setAddress(rs.getString(Constants.ADDRESS));
				emp.setEmployeeId(rs.getInt(Constants.EMPLOYEEID));
				emp.setPassword(rs.getString(Constants.PASSWORD));
			}else {
				System.out.println("Employee not found");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return emp;
	}

}
