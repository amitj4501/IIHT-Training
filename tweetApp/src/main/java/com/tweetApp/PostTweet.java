package com.tweetApp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class PostTweet {

	static final String URL = "jdbc:mysql://localhost:3306/test";
	static final String USER = "root";
	static final String PASSWORD = "pass@word1";
	static final String QUERY ="insert into tweets (tweet_id,email,tweet) values(?,?,?);";
	
	public static void addPost(){
        try(Connection con =DriverManager.getConnection(URL,USER,PASSWORD);
            Statement stmt= con.createStatement();

            PreparedStatement ps = con.prepareStatement(QUERY))
        {
            Scanner sc = new Scanner(System.in);
            System.out.println("enter email");
            String email =sc.nextLine();
            System.out.println("enter tweet");
            String tweet =sc.nextLine();
            System.out.println("enter tweet id");
            int id =sc.nextInt();


            ps.setInt(1,id);
            ps.setString(2,email);
            ps.setString(3,tweet);
            ps.executeUpdate();
        }

        catch(SQLException e)
        {
            e.printStackTrace();
        }



    }
}
