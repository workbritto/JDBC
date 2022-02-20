package org.demqqa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class DemoQaPractice {
	public static void main(String[] args) {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/newnew_schema","root","");
			String sql = "insert into new_table(name,pass,phone)values(?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			Scanner sc = new Scanner(System.in);
			System.out.println("Name");
			String name = sc.next();
			System.out.println("password");
			String pass = sc.next();
			System.out.println("phone");
			String phone = sc.next();
			
			ps.setString(1, name);
			ps.setString(2, pass);
			ps.setString(3, phone);
			
			ps.executeUpdate();
			System.out.println("success");
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
