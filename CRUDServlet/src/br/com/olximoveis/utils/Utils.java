package br.com.olximoveis.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Utils {
	public static class Date {
		public static final DateFormat FORMATADOR_DEFAULT = new SimpleDateFormat("dd-MM-yyyy");
		public static String format(java.util.Date date) {
			if(date != null) {
				return FORMATADOR_DEFAULT.format(date);
			} else {
				return null;
			}
			
		}
	}
	
	public static class Database {
		private static String jdbcURL = "jdbc:oracle:thin:@localhost:49161:xe";
	    private static String jdbcUsername = "system";
	    private static String jdbcPassword = "oracle";
	    public static Connection jdbcConnection;
		
		public static void connect() throws SQLException {
	        if (jdbcConnection == null || jdbcConnection.isClosed()) {
	            try {
	                Class.forName("oracle.jdbc.driver.OracleDriver");
	            } catch (ClassNotFoundException e) {
	                throw new SQLException(e);
	            }
	            jdbcConnection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
	        }
	    }
	     
	    public static void disconnect() throws SQLException {
	        if (jdbcConnection != null && !jdbcConnection.isClosed()) {
	            jdbcConnection.close();
	        }
	    }
	}
}
