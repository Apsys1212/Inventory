package database;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dbConnection {
static Connection conn;

public static Connection getConn() {
	
	
	String db="test";//to be configured
	String url="jdbc:mysql://localhost:3306/";
//String url="jdbc:mysql://mysql4028-env-0144358.ind-cloud.everdata.com/hms";
       try {
		Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection(url+db,"root","root");
			//conn=DriverManager.getConnection(url,"root","lHNOPHoQU4");
		 	if(conn==null){
		 		System.out.println("not connected...");
		 	}
		 	else{
		 		System.out.println("connected...");
		 	}
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block 
		e.printStackTrace();
	}
	catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();


	}
	return conn;
}

public static void setConn(Connection conn) {
	dbConnection.conn = conn;
}




}
