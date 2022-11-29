package com.tweetApp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Registration {

    static final String URL ="jdbc:mysql://localhost:3306/test";
    static final String USER ="root";
    static final String PASSWORD ="pass@word1";
    static final String QUERY ="insert into Users (first_name,email,password,login_status) values(?,?,?,?);";

    public static void register(){
        try(Connection con =DriverManager.getConnection(URL,USER,PASSWORD);
            Statement stmt= con.createStatement();

            PreparedStatement ps = con.prepareStatement(QUERY);)
        {
            Scanner sc = new Scanner(System.in);

            System.out.println("Create An Account");

            System.out.println("Enter Full name");
            String firstName =sc.nextLine();
            System.out.println("Enter Email address");
            String email =sc.nextLine();
            System.out.println("Enter password ");
            String password =sc.nextLine();

            int loginStatus=0;


            ps.setString(1,firstName);
            ps.setString(2,email);
            ps.setString(3,password);
            ps.setInt(4,loginStatus);
            ps.executeUpdate();

            System.out.println("Registration Completed");
            System.out.println("**********************");
        }

        catch(SQLException e)
        {
        	e.printStackTrace();

        }



    }
}