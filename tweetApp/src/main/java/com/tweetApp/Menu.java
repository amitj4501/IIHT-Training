package com.tweetApp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Menu 
{
    public static void main( String[] args ) throws IOException
    {
    	boolean Start = true;
    	BufferedReader br;
    	String str;
    	int j;
    	while(Start) {
    		System.out.println( "Welcome to tweet app" );
            System.out.println( "**********" );
            System.out.println("1.Register");
            System.out.println("2.Login");
            System.out.println("3.Forgot password");
            
            br = new BufferedReader(new InputStreamReader(System.in));
            str = br.readLine();
            j = Integer.parseInt(str);
            
            
            switch(j) {
            case 1:
            	Registration.register();
                break;
                
                
            case 2: 
            	Login.login();
            	boolean Continue=true;
            	while(Continue) {
                    System.out.println("Welcome to your Account....");
                    System.out.println("---------------------");
                    System.out.println("1.Post a Tweet");
                    System.out.println("2.View my Tweet");
                    System.out.println("3.View All Tweet");
                    System.out.println("4.View All Users ");
                    System.out.println("5.Reset Password");
                    System.out.println("6.LogOut");
                    //br = new BufferedReader(new InputStreamReader(System.in));
                    str= br.readLine();
                    j=Integer.parseInt(str);
                    switch (j) {
                        case 1:
                            PostTweet.addPost();
                            break;

                        case 2:
                        	Retrieve.retriveTweet();
                            break;

                        case 3:
                        	Retrieve.retrieveAll();

                            break;

                        case 4:
                        	RetrieveUser.retriveUser();
                            break;


                        case 5:
                            ResetPwd.reset();
                            break;

                        case 6:
                            System.out.println("User Logged Out Successfully");
                            System.out.println("---------------------");
                            Login.logOut();
                            System.exit(0);

                            break;

                        default:
                            System.out.println("Please select the accurate number");
                            break;



                    }

                }
            	
                
//            case 3:
//                Retrieve.retriveTweet();
//                break;
//                
//                
//            case 4:
//            	Retrieve.retrieveAll();
//
//                break;
//
//            case 5:
//            	RetrieveUser.retriveUser();
//                break;
//
//
//            case 6:
//                ResetPwd.reset();
//                break;

            case 7:
                System.out.println("User Logged Out Successfully");
                System.out.println("---------------------");
                Login.logOut();
                System.exit(0);

                break;

            default:
                System.out.println("Please select the accurate number");
                break;    
            }
            System.out.println("Do you want to continue? y/n");
            String s1 = br.readLine();
            if(s1.equals("y") ||  s1.equals("yes") || s1.equals("Y") ||  s1.equals("YES")) {
                Start=true;
            }
            else {
                Start=false;
            }
            
    	}
        
        
    }
}
