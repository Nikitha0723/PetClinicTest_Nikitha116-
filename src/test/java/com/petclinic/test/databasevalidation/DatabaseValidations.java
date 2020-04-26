package com.petclinic.test.databasevalidation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.apache.log4j.Logger;
import static org.junit.Assert.assertEquals;

public class DatabaseValidations {
	static Logger logger = Logger.getLogger(DatabaseValidations.class);

	public static void main(String[] args) {

		try {
			Class.forName("org.h2.Driver");
			Connection conn = DriverManager.getConnection("jdbc:h2:mem:testdb", "sa", "");
			Statement stmt = conn.createStatement();

			String create = "CREATE TABLE OWNERS " + "(id INTEGER, " + " first_name VARCHAR(255), "
					+ " last_name VARCHAR(255), " + " address VARCHAR(255), " + " city VARCHAR(255), "
					+ " telephone VARCHAR(255))";

			String insert = "INSERT INTO OWNERS "
					+ "VALUES (111, 'Nikitha', 'Tanneru', 'Reem','AbuDhabi','0587777777')";

			String get = "SELECT id, first_name, last_name, address, city, telephone FROM OWNERS";

			stmt.executeUpdate(create);
			stmt.executeUpdate(insert);

			logger.info("Data Inserted for testing");

			ResultSet rs = stmt.executeQuery(get);

			while (rs.next()) {

				int id = rs.getInt("id");

				if (id == 111) {

					String first_name = rs.getString("first_name");
					String last_name = rs.getString("last_name");
					String address = rs.getString("address");
					String city = rs.getString("city");
					String telephone = rs.getString("telephone");

					assertEquals(first_name, "Nikitha");
					assertEquals(last_name, "Tanneru");
					assertEquals(address, "Reem");
					assertEquals(city, "AbuDhabi");
					assertEquals(telephone, "0587777777");

					logger.info("Owner Validation successful");
				}

			}

		} catch (Exception e) {
			logger.info("Error" + e);
		}
	}
}