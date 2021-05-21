package com.cts.daoimpl;

import com.cts.dao.Employee;
import com.cts.model.Employee;

public class EmployeeDaoImpl implements EmployeeDao {
	
	//database info
	private final String db_username="root";
	private final String db_password="root";
	private final String db_driver="com.jdbc.mysql.Driver";
	private final String db_url="jdbc:mysql://localhost:3306/admin017"
	@override
	public void addEmployee(Employee empObj) {
	
		try {
			//step-1:  load the driver
			Class.forName(db_driver);
			
			//step -2: get the connection
			Connection connectionObj=DriverManager.getConnection(db_url, db_username, db_password);
			
			//step-3: Write your Queries
			String insertQuery="insert into employee_table1 values(?,?,?,?";
			pStatement=connectionObj.prepareStatement(insertQuery);
			
			empObj.setEmployeeId(1122);
			empObj.setEmployeeName("Rajinikanth");
			empObj.setEmployeeSalary(150000.00);
			empObj.setEmployeeAge(55);
			
			pStatement.setInt(1, empObj.getEmployeeId());
			pStatement.setString(2, empObj.getEmployeeName());
			pStatement.setDouble(3, empObj.getSalary());
			pStatement.setInt(4, empObj.getAge());
			
			//step-4: execute Statements
			pStatement.executeUpdate();
			System.out.println("Data has been successfully inserted.");
			
		}catch(Exception exception) {
			exception.printStackTrace();
		}finally {
			//step-5: close thepStatement and connection
			if(pStatement!=null) {
				try {
					pStatement.close();
				}catch()SQL
			}
			
		}
			
		}
	}


