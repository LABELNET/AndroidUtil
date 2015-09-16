package cn.yuan.DBO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//dbo连接mysql
public class DBO {
	//     MySQL    ݿ      
		public static final String DBDRIVER = "org.gjt.mm.mysql.Driver" ;
 
		public static final String DBDURL = "jdbc:mysql://localhost:3306/test" ;
		//mysql  ݿ       û   
		public static final String DBUSER = "yuan" ;
		//mysql  ݿ          
		public static final String DBPASS = "labelnet" ;
		
		static{	
			try {
				Class.forName(DBDRIVER);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		public static Connection getConnection(){
			Connection conn=null;
			try {
				conn=DriverManager.getConnection(DBDURL,DBUSER,DBPASS);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return conn;
		}
		
		public static void close(ResultSet rs,Statement st,Connection conn){
			
			try {
					
					if(rs!=null){
					rs.close();
					}
					if(st!=null){
						st.close();
					}
					if(conn!=null){
						conn.close();
					}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} 
		
		public static void close(Statement st,Connection conn){
			close(null,st,conn);
		}

}
