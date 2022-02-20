package org.greenexcersise;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class DemoQa {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/demoqa_schema","root","");
			PreparedStatement ps = con.prepareStatement("select * from emp_table");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int id = rs.getInt("EmpId");
				System.out.println(id);
				String name = rs.getString("EmpName");
				System.out.println(name);
				String salary = rs.getString("EmpSalary");
				System.out.println(salary);
				String empAddress = rs.getString("EmpAddress");
				System.out.println(empAddress);
			}
			System.out.println("success");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
