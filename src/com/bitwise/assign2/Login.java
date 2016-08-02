package com.bitwise.assign2;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
//@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		 HttpSession session =  request.getSession(true);
		 String sid=session.getId();
				 
		 session.setAttribute("name",request.getParameter("name"));    
		 session.setAttribute("sid",sid);   
			
			session.setMaxInactiveInterval(2*60);
			
			
			if (session.isNew()) {
				out.println("<br><h1> Login </h1>");
				out.print("<br> <font> logged in!</font>");  
		        out.print("<br><br>Welcome, "+request.getParameter("name")); 
		        //out.print("<br><br><font color=blue>Proceed further to create your profile</font> <br>"); 
		        request.getRequestDispatcher("OnlineShopingPage.jsp").include(request, response);
			} else {
				out.println("<br><h1> Welcome Back</h1> " + session.getAttribute("name"));
			}
		
		
       
       
      
	}  
		 
		 
		
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
