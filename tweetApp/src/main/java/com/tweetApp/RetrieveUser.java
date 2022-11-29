package com.tweetApp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RetrieveUser {
	static final String URL = "jdbc:mysql://localhost:3306/test";
	static final String USER = "root";
	static final String PASSWORD = "pass@word1";
	static final String QUERY = "select distinct email from tweets";
	
	
	
	public static void retriveUser()
    {
        try{
            Connection con =DriverManager.getConnection(URL,USER,PASSWORD);

            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(QUERY);

            while (rs.next()) {
                System.out.println("Email: " + rs.getString("email"));

            }

        }

        catch(SQLException e)
        {
        	e.printStackTrace();

        }



    }
}
