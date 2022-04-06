package com.ibm;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class UserData1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");  
		PrintWriter out = response.getWriter();  
		          
		String n=request.getParameter("UserName");  
		int p=Integer.parseInt(request.getParameter("UserAge"));  
		String q=request.getParameter("UserGender");  
		String r=request.getParameter("UserPwd");  
		
		          
		try{  
			
		Class.forName("oracle.jdbc.driver.OracleDriver"); 
		
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system"); 
		
		PreparedStatement ps=con.prepareStatement("insert into UserDetail(USERNAME,AGE,GENDER,PASSWORD)  values(?,?,?,?)");  
		  
		ps.setString(1,n);  
		ps.setLong(2,p);
		ps.setString(3,q);
		ps.setString(4,r);
		
		 
		          
		int i=ps.executeUpdate();  
		if(i>0)  
		out.print("You are successfully registered...");  
		  con.close();    
		          
		}catch (Exception e2) {System.out.println(e2);}  
		          
		out.close();  
	}
		
		
		
		
	}


