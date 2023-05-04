package factory;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexionFactory {

	private final String URL = "jdbc:mysql://localhost:3306/Hotelalura?useTimeZone=true&serverTimeZone=UTC";
	private final String NAME = "root";
	private final String PASS = "0611";

	Connection conexion;

	public ConexionFactory() {

	}

	public Connection getConnection() {

		try {

			Class.forName("com.mysql.jdbc.Driver");
			conexion = DriverManager.getConnection(URL, NAME, PASS);

		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(e);

		}
		return conexion;

	}

}
