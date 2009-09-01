package de.fzi.stanja.sissyconnector.dbaccess;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;

import de.fzi.stanja.sissyconnector.exceptions.JDBCException;



public class DatabaseCleaner {
	private static final int COLUMN_JDBC_TABLENAME = 3;
	private static final Logger logger = Logger.getLogger(DatabaseCleaner.class);
	private Connection connection = null;

	public DatabaseCleaner(Connection connection) {
		this.connection = connection;
	}

	public void flush() throws JDBCException {
		this.dropTables();
	}

	private void dropTables() throws JDBCException {
		String[] tableTypes = { "TABLE" };
		try {
			DatabaseMetaData dmd = this.connection.getMetaData();
			ResultSet rs = dmd.getTables(null, null, "%", tableTypes);
			Statement statement = this.connection.createStatement();

			while (rs.next()) {
				String tableName = rs.getString(COLUMN_JDBC_TABLENAME);
				String dropStatement = "DROP TABLE " + tableName + " CASCADE";
				logger.info("execute sql drop statement:  \"" + dropStatement + "\"");
				statement.execute(dropStatement);
			}
			rs.close();
			statement.close();
		} catch (SQLException e) {
			String message = "drop tables failed";
			logger.error(message, e);
			throw new JDBCException(message, e);

		}
	}
}
