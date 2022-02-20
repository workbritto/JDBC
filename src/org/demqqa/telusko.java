package org.demqqa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.PreparedStatement;

public class telusko {
	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/selenew_schema";
		String username = "root";
		String passw = "";
		String name = "nancy";
		String password = "7";
		String email = "email.com";
		String Query = "insert into company_table(name,password,email) values(?,?,?)";
		
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = DriverManager.getConnection(url,username,passw);
				java.sql.PreparedStatement st = con.prepareStatement(Query);
				st.setString(1, name);
				st.setString(2, password);
				st.setString(3, email);
				int count = st.executeUpdate();
				System.out.println(count+"row/s affected");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		
	}
}
