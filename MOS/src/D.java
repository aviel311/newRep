

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class D
 */
@WebServlet("/D")
public class D extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public D() {
        super();
        // TODO Auto-generated constructor stub
    }
    String url =hagdarot.URL;
    String username = hagdarot.USERNAME;
    String password = hagdarot.PASSWORD;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html; charset = UTF-8");
		PrintWriter printToClint= response.getWriter();

		printToClint.print("<!DOCTYPR html><html> <head><meta charset='utf-8'><title>אורז</title><style>table, th, td {border: 2px solid red;border-collapse: collapse;}th, td {padding: 5px;text-align: left;}</style></head><body><!DOCTYPE html></body></html>");
		printToClint.print("<h1>email list</h1>");
		printToClint.print("<table>");
		String email = request.getParameter("delete_email");
		String sqlInsert = "DELETE FROM public.emails WHERE mail ='"+email+"'";
		
		Connection connection = null;
		Statement statement = null;
		 try 
	        {
	            Class.forName("org.postgresql.Driver");
	            connection = DriverManager.getConnection(url, username, password);
	           	statement = connection.createStatement();
	           	statement.executeUpdate(sqlInsert);
	           	statement.close();
	           	connection.close();
	           	
	           	response.sendRedirect("A"); 
	            printToClint.println("</table>");
	        
	}
		 catch (ClassNotFoundException | java.sql.SQLException e) 
	        {
		            System.out.println(e.getMessage());
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
