package org.test;

import java.awt.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class Test {
	public ArrayList<Employee> getEmployeeInfo() {
		ArrayList<Employee> emp = new ArrayList<Employee>();
		Connection con = null;
		try {
			// load the driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			// connect to database
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/selenew_schema", "root", "");
			//write sql query
			String sql = "select * from company_table";
			//prepare the statement
			PreparedStatement ps = con.prepareStatement(sql);
			//Execute query
			ResultSet rs = ps.executeQuery();
			Employee e = new Employee();

			while(rs.next()) {
				int id = rs.getInt("empid");
				System.out.println(id);
				String name = rs.getString("name");
				System.out.println(name);
				String pass = rs.getString("password");
				System.out.println(pass);
				String email = rs.getString("email");
				System.out.println(email);
				e.setEmpid(id);
				e.setName(name);
				e.setPassword(pass);
				e.setEmail(email);
				emp.add(e);
			}
			System.out.println("Success");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return emp;
	}
	// To store all the values, use user defined concept
	public static void main(String[] args) {
		Test t = new Test();
		t.getEmployeeInfo();
	}
}
