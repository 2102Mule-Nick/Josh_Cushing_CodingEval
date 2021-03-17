package com.famtr;

import java.sql.SQLException;
import java.util.Scanner;

import org.apache.log4j.Logger;

public class Driver {

	public static void main(String[] args) {

		displayOptions();

	}

	public static void displayOptions() {
		Logger log = Logger.getRootLogger();
		Scanner scan = new Scanner(System.in);
		Dao dao = new Dao();

		Pojo testPojo = new Pojo("Simon", "Zays", 0, "George", "Zays", 0, "Clarisse", "Chinz");

		System.out.println("What would you like to do?");
		String input = scan.next();

		String fname;
		String lname;

		System.out.println("1) Create family Member");
		System.out.println("2) Retreive family Member");
		System.out.println("3) Delete family Member");
		System.out.println("4) See ancestors");
		switch (input) {

		case "1":
			try {
				dao.createMember(testPojo);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "2":
			fname = testPojo.getfName();
			lname = testPojo.getlName();
			try {
				dao.retreiveMember(fname, lname);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "3":
			fname = testPojo.getfName();
			lname = testPojo.getlName();
			try {
				dao.deleteMember(fname, lname);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "4":
			try {
				dao.continueUpTree(testPojo);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;

		default:
			System.out.println("Invalid entry");
			displayOptions();
		}

	}
	/*
	 * Pojo testPojo = new Pojo("Simon", "Zays", 0, "George", "Zays", 0, "Clarisse",
	 * "Chinz");
	 * 
	 * try { // TEST 1 Create //dao.createMember(testPojo);
	 * 
	 * // TEST 2 Retreive // String fname = testPojo.getfName(); // String lname =
	 * testPojo.getlName(); // dao.retreiveMember(fname, lname);
	 * 
	 * // TEST 3 Delete // String fname = testPojo.getfName(); // String lname =
	 * testPojo.getlName(); // dao.deleteMember("Candice", "McOlderson");
	 * 
	 * // TEST 4 Continue to next ancestor // dao.continueUpTree(testPojo);
	 * 
	 * } catch (SQLException e) { log.warn("Hey that didn't work");
	 * e.printStackTrace(); }
	 */

}
