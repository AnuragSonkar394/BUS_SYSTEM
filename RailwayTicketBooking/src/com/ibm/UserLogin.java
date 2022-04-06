package com.ibm;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UserLogin
 */
public class UserLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  
		 
		response.setContentType("text/html");  
		PrintWriter out = response.getWriter();  
		          
		String uname=request.getParameter("AdName");
		String pwd=request.getParameter("AdPass"); 
		  

		          
		try{
			
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system"); 

		String vsql="select *from userdetail"; 

		Statement st= con.createStatement();
		ResultSet rs=st.executeQuery(vsql);


		while (rs.next()) 
		{ 
			if(rs.getString(1).equals(uname)&& rs.getString(4).equals(pwd))
			{ 
				RequestDispatcher rd=request.getRequestDispatcher("/ShowTrain@.jsp");  
		         rd.forward(request, response); 
		         con.close();
		         break;
		    } 

		 
			
		 
		       
		      
		}  
		    out.print("Sorry UserName or Password Error!");  
		    RequestDispatcher rd=request.getRequestDispatcher("/web.html");  
		    rd.include(request, response);  
		  


		con.close();
		 }
		catch (Exception e2) {System.out.println(e2);}  
		          
		out.close();  
		}  
}


