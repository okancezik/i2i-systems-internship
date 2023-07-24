package voltdb_learn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class VoltDBConnection {
	
	private static String jdbcUrl = "jdbc:voltdb://localhost:37268";
	private static String username = "";
	private static String password = "";
	
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(jdbcUrl, username, password);
	}
}
