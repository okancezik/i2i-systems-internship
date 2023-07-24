package voltdb_learn;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

	public static void main(String[] args) throws SQLException {

		try {
			// Load the VoltDB JDBC driver
			Class.forName("org.voltdb.jdbc.Driver");
			Connection connection = VoltDBConnection.getConnection();
			System.out.println("Connected VoltDB");

			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM SUBSCRIBER");
			while (resultSet.next()) {
				int subscId = resultSet.getInt("SUBSC_ID");
				String subscName = resultSet.getString("SUBSC_NAME");
				System.out.println("SUBSC_ID: " + subscId + ", SUBSC_NAME: " + subscName);
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
