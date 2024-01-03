package mysql.client;

import mysql.DAO.DataBase;
import mysql.entity.Employee;

public class App {

	public static void main(String[] args) {
		
		DataBase db = new DataBase();
		Employee e = new Employee();
		e.setId(2);
		e.setName("Anup");
		e.setGender("Male");
		e.setSalary(90900);
		
		
		db.insert(e);
		db.showEmployeeData();
		
	}

}		
