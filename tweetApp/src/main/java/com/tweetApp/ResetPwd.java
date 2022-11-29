package com.tweetApp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class ResetPwd {

	static final String URL = "jdbc:mysql://localhost:3306/test";
	static final String USER = "root";
	static final String PASSWORD = "pass@word1";
	static final String QUERY ="update Users set password=? where email=? ;";
	
	public static void reset() {
        try(Connection con =DriverManager.getConnection(URL,USER,PASSWORD);
            Statement stmt= con.createStatement();

            PreparedStatement ps = con.prepareStatement(QUERY);)
        {
            Scanner sc = new Scanner(System.in);
             System.out.println("Password Rest Page :");
            System.out.println("---------------------");
            System.out.println("Enter email:");
           
            String email =sc.nextLine();
         
            System.out.println("New Password ");
            String pass =sc.nextLine();
            ps.setString(1,pass);
             ps.setString(2,email);
           int b =  ps.executeUpdate();
          
            if(b==1) {
                System.out.println("Password Successfully Updated");

            }
            else {
                System.out.println("Password Update Failed");
            }

        }

        catch(SQLException e)
        {
           e.printStackTrace();
        }



    }
}
