


import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class amail
 */
@WebServlet("/amail")
public class amail extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 String url =hagdarot.URL;
     String username = hagdarot.USERNAME;
     String password = hagdarot.PASSWORD;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public amail() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String email = request.getParameter("mail");
		String firstname = request.getParameter("fname");
		String lastname = request.getParameter("lname");
		
		String sqlInsert= "INSERT INTO public.emails (mail, fname, lname) VALUES ('"+email+"','"+firstname+"','"+lastname+"')";
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
