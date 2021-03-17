package com.famtr;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.log4j.Logger;

public class Connextion {

	Logger log = Logger.getRootLogger();

	public static String URL;

	public static String USERNAME;

	public static String PASSWORD;
	
	public static String DB_NAME;
	
	private static Connextion connextion = null;

	private Connextion() {
		
		DB_NAME = System.getenv("DB_NAME");
		
		URL = "jdbc:postgresql://" + System.getenv("DB_URL") + ":5432/" + DB_NAME + "?";

		USERNAME = System.getenv("DB_USERNAME");

		PASSWORD = System.getenv("DB_PASSWORD");
	}
	
	
	public Connection createConnection() {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("Failed to load Driver");
		}

		log.info("URL : " + URL);

		try {
			System.out.println();
			return DriverManager.getConnection(URL, USERNAME, PASSWORD);
			
		} catch (SQLException e) {
			e.printStackTrace();
			log.error("Failed to connect to DB", e);
		}
		return null;
	}
	

	public static synchronized Connection getConnection() {	
		if (connextion == null) {
			connextion = new Connextion();
		}

		return connextion.createConnection();
	}
}
