package mysql.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import mysql.entity.Employee;

public class DataBase {
	static Connection con;
	static {
	
	try {
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mic", "root", "3121");
	} catch (SQLException e) {
		e.printStackTrace();
	}

	}
	
	public void insert(Employee e)
	{
		try {

			Statement stmt = con.createStatement();
			stmt.executeUpdate(String.format("insert into Employee(id,name,gender,salary) values (%d,\"%s\",\"%s\",%d)",
					e.getId(), e.getName(), e.getGender(), e.getSalary()));
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		System.out.println("Mission successful.............");

	}
	
	
	public void showEmployees()
	{
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from Employee");
		
		while(rs.next())
		{
			System.out.println("Id : "+ rs.getInt(1)+"  Name : "+ rs.getString(2)+ "  Gender : "+ rs.getString(3)+ "  Salary : "+ rs.getInt(4));
		}
		
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	
	
}
