package projectWithJDBC.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

	private static Connection connection = null;

	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/student";
			String username = "root";
			String password = "01092003Zh";
			try {
				connection = DriverManager.getConnection(url, username, password);

			} catch (SQLException e) {

				e.printStackTrace();
			}

		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}
		return connection;

	}

	public static void connectionClose() {
		try {
			connection.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

}
