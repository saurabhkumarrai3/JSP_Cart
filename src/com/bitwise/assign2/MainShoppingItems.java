package com.bitwise.assign2;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class MainShoppingItems
 */
@WebServlet("/MainShoppingItems")
public class MainShoppingItems extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Map<Integer, String> map=new HashMap<Integer, String>();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainShoppingItems() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession(false);
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		request.getRequestDispatcher("ShoppingOptions.jsp").include(request, response);
		if(session!=null)
		{
			if(request.getParameter("add")!=null)
			{
				String[] shopingItems=request.getParameterValues("ShopingItems");
				for(int i=0;i<shopingItems.length;i++)
				{
					map.put(new Integer(i+1),shopingItems[i]);
				}
		
				for(Map.Entry<Integer, String> entry : map.entrySet())
				{
					out.println("<html><body>");
					out.println("<table>");
					out.println("<head><h3><tr><td>"+entry.getKey()+"</td><td>"+entry.getValue()+"</td></tr></h3>");
					out.println("</head></table></html></body>");
					
				}
				//request.getRequestDispatcher("ShoppingOptions.jsp").include(request, response);
			
			}
			else if(request.getParameter("Delete")!=null)
			{
				//out.println("<html1><head><h3>Selected items are added to cart successfully</h3></head></html1>");
				int key=Integer.parseInt(request.getParameter("delete"));
			
				map.remove(key);
				out.println("Item deleted successfully\n\n");
				request.getRequestDispatcher("DisplayItem.jsp").include(request, response);
				request.getRequestDispatcher("logout.jsp").include(request, response);
			}
		//iterator values from map
			else if((request.getParameter("display")!=null))
			{	
			
				out.println("<html1><head><h2>Selected items are :\n</h2></head></html1>");
				for(Map.Entry<Integer, String> entry : map.entrySet())
				{
					out.println("<html><body>");
					out.println("<table>");
					out.println("<head><h3><tr><td>"+entry.getKey()+"</td><td>"+entry.getValue()+"</td></tr></h3>");
					out.println("</head></table></html></body>");					
				}
					request.getRequestDispatcher("logout.jsp").include(request, response);
			}
			
		}
		else{
			out.println("login first");
			request.getRequestDispatcher("index.html").include(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
