package kis.databaseservices;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class KatikamuDbConnection {
	public Connection getDbConnection() throws SQLException {
		try {
			String connectionUrl = "jdbc:mysql://localhost:3306/katikamu";
			String db_username = "root";
			String db_password = "root";
			Connection connection = DriverManager.getConnection(connectionUrl, db_username, db_password);
			return connection;
		} catch (SQLException sqlException) {
			throw sqlException;
		}
	}
}
