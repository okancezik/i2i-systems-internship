package apache_ignite_learn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class IgniteConnection {

	private static String jdbcUrl = "jdbc:ignite:thin://127.0.0.1:10800/";
	private static String username = "okacezik@gmail.com";
	private static String password = "12345";
	
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(jdbcUrl,username,password);
	}
}
