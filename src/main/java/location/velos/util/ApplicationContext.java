package location.velos.util;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.hsqldb.jdbc.JDBCDataSource;

public class ApplicationContext {

	private static JDBCDataSource DATASOURCE;

	private static DataSource getApplicationDataSource() {
		if (DATASOURCE == null) {
			DATASOURCE = new JDBCDataSource();
			DATASOURCE.setUrl("jdbc:hsqldb:file:D:/TechnoMaker/workspace/velos/bd");
			DATASOURCE.setUser("sa");
			DATASOURCE.setPassword("");
		}
		return DATASOURCE;
	}

	public static Connection getConnexion() throws SQLException {
		DataSource ds = getApplicationDataSource();
		return ds.getConnection();
	}

}
