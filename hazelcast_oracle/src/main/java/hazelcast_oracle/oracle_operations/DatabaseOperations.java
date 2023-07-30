package hazelcast_oracle.oracle_operations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseOperations {
	
	private static String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:TEST";
	private static String username = "OKAN";
	private static String password = "12345";
	
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(jdbcUrl, username, password);
	}

}
