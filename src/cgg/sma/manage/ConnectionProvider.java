package cgg.sma.manage;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionProvider {
	
	static Connection conn;
	
	public static Connection createConnection(){
		try {
			Class.forName("org.postgresql.Driver");
			String url = "jdbc:postgresql://localhost:5432/cgg_interns";
			String username = "postgres";
			String password = "cgg123";
			
			conn = DriverManager.getConnection(url,username,password);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return conn;
	}

}
