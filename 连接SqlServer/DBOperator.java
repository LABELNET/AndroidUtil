package cn.edu.hpu.stumanager.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBOperator {
	
	private static String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private static String url = "jdbc:sqlserver://localhost:1433;" +
	   "databaseName=jsp_students;user=sa;password=playnet;";
	
	static
	{
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection()
	{
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	public static void close(ResultSet rs, Statement st, Connection conn)
	{
		try
		{
			if(rs != null)
			{
				rs.close();
			}
			if(st != null)
			{
				st.close();
			}
			if(conn != null)
			{
				conn.close();
			}
			
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
	}
	
	public static void close(Statement st, Connection conn)
	{
		close(null,st,conn);
	}
	

}
