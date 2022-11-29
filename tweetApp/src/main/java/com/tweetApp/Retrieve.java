package com.tweetApp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Retrieve {

	static final String URL = "jdbc:mysql://localhost:3306/test";
	static final String USER = "root";
	static final String PASSWORD = "pass@word1";
	static final String QUERY = "select tweet from tweets where tweet_id = ? ";
	//static final String QUERY = "select tweet from tweets;";
	static final String QUERY2 ="select distinct * from tweets";

	public static void retriveTweet() {
		try {
			Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("query: " + QUERY);
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(QUERY);
			System.out.println("Tweet id: " + rs);

			while (rs.next()) {

				System.out.println("Tweet id: " + rs.getInt("tweet_id"));
				System.out.println("Email: " + rs.getString("email"));
				System.out.println("Tweet : " + rs.getString("tweet"));

			}

		}

		catch (SQLException e) {
                e.printStackTrace();
		}
	}

	public static void retrieveAll() {
		try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(QUERY2)) {
			while (rs.next()) {

				System.out.println("Tweet id: " + rs.getInt("tweet_id"));
				System.out.println("Email: " + rs.getString("email"));
				System.out.println("Tweet : " + rs.getString("tweet"));

			}

		}

		catch (SQLException e) {
             e.printStackTrace();   
		}
	}
}
