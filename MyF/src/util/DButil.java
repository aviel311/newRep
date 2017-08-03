package util;
import java.sql.*;

import org.springframework.jdbc.datasource.DriverManagerDataSource;
public class DButil {
	private static Connection connection ;
	public	static final String URL = "jdbc:postgresql://echo.db.elephantsql.com:5432/ehlyedof";
	 public	static final String USERNAME = "ehlyedof";
	 public	static final String PASSWORD = "0VyqIY3MaF8gSft6w6H1VmcI8y3GwqpW";
	 
	public static Connection getconnection() {
		if (connection !=null)
			return connection;
		
	 
	
	try {
		Class.forName ("org.postgresql.Driver");
		connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
		
	}
	catch (ClassNotFoundException|java.sql.SQLException e){
		System.out.println(e.getMessage());
	}
	return connection;
	}
	
	
	public static void closeConnection (Connection toBeClosed){
		if(toBeClosed != null)
			return;
		try{
			toBeClosed.close();
			
		}catch (SQLException e) {
			System.out.println(e.getMessage());
			// TODO: handle exception
		}
	}
	
	
	}
	
