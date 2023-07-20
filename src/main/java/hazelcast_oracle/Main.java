package hazelcast_oracle;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;
import java.util.Random;

import hazelcast_oracle.hazelcast_operations.HazelcastOperations;
import hazelcast_oracle.oracle_operations.DatabaseOperations;

public class Main {

	public static void main(String[] args) throws SQLException {
		
		//insertOracleDatabase();
		//getFromOracleDatabase();
		//insertToHazelcast();
		//getFromHazelcast();

	}

	public static void insertOracleDatabase() throws SQLException {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection connection = DatabaseOperations.getConnection();
			System.out.println("baglantı olustu");

			Random rand = new Random();

			Statement statement = connection.createStatement();
			long startTime = System.currentTimeMillis();
			for (int i = 1; i < 20000; i++) {
				statement.executeUpdate("INSERT INTO NUMBERS VALUES(" + i + "," + rand.nextInt(100) + ")");
			}
			long endTime = System.currentTimeMillis();

			long elapsedTime = endTime - startTime;

			double seconds = elapsedTime / 1000.0;
			System.out.println("İşlem süresi: " + seconds + " saniye");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static void getFromOracleDatabase() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection connection = DatabaseOperations.getConnection();
			System.out.println("Connected");
			Statement statement = connection.createStatement();
			
			long startTime = System.nanoTime();

			for (int i = 0; i < 100000; i++) {
				Random random = new Random();
				int index = random.nextInt(200);
				ResultSet result = statement.executeQuery("select PUAN from NUMBERS where NUMBERID = " + index + "");
				while (result.next()) {
					int puan = result.getInt("PUAN");
					//System.out.println("PUAN: " + puan);
				}
				result.close();
			}
			
			long endTime = System.nanoTime();

			long elapsedTime = endTime - startTime;
			double seconds = (double) elapsedTime / 1_000_000_000.0;
			System.out.println("İşlem süresi: " + seconds + " saniye");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void insertToHazelcast() {
		Map<Object, Object> myMap = HazelcastOperations.getMap();

		Random rand = new Random();

		long startTime = System.nanoTime();

		for (int i = 1; i < 20000; i++) {
			String key = "" + i;
			myMap.put(key, rand.nextInt(100));
		}
		long endTime = System.nanoTime();

		long elapsedTime = endTime - startTime;
		double seconds = (double) elapsedTime / 1_000_000_000.0;
		System.out.println("İşlem süresi: " + seconds + " saniye");
	}
	
	public static void getFromHazelcast() {
		Map<Object, Object> myMap = HazelcastOperations.getMap();
		Random rand = new Random();
		
		long startTime = System.nanoTime();
		
		for(int i=0;i<10;i++) {
			int index = rand.nextInt(200);
			String key = ""+index ;
			Object value = myMap.get(key);
			System.out.println(value);
		}
		
		long endTime = System.nanoTime();

		long elapsedTime = endTime - startTime;
		double seconds = (double) elapsedTime / 1_000_000_000.0;
		System.out.println("İşlem süresi: " + seconds + " saniye");
	}

}
