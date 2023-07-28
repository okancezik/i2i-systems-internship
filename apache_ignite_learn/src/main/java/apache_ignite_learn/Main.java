package apache_ignite_learn;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {

	public static void main(String[] args) {

		try {
			Class.forName("org.apache.ignite.IgniteJdbcThinDriver");
			Connection connection = IgniteConnection.getConnection();
			System.out.println("Connected apache ignite");

			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM SUBSCRIBER");

			while (rs.next()) {
				int subscId = rs.getInt("SUBSC_ID");
				String subscName = rs.getString("SUBSC_NAME");

				System.out.println("SUBSC_ID: " + subscId + ", SUBSC_NAME: " + subscName);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
