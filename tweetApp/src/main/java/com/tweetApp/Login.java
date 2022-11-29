package com.tweetApp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Login {

	static final String URL = "jdbc:mysql://localhost:3306/test";
	static final String USER = "root";
	static final String PASSWORD = "pass@word1";
	static final String QUERY = "select * from Users where email=? and password=?;";
	static String email;

	public static void login() {
		try {
			Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
			Statement stmt = con.createStatement();

			PreparedStatement ps = con.prepareStatement(QUERY);

			Scanner sc = new Scanner(System.in);
			
			System.out.println("Enter email address");
			email = sc.nextLine();
			System.out.println("Enter password ");
			String pass = sc.nextLine();

			
			ps.setString(1, email);
			ps.setString(2, pass);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				System.out.println("Login Successfully ");
				System.out.println("---------------------");
				String sql = "update Users" + "  SET login_status = 'YES' where email = '" + email + "'";
				
				stmt.executeUpdate(sql);

			} else {
				System.out.println("Login Failed");
			}
		}

		catch (SQLException e) {
           e.printStackTrace();
		}

	}

	public static void logOut() {
		try {
			Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
			Statement stmt = con.createStatement();

			String sql = "update Users" + "  SET login_status = 'NO' where email = '" + email + "'";
			
			stmt.executeUpdate(sql);
		} catch (SQLException e) {

		}

	}

}
