package com.famtr;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.apache.log4j.Logger;


public class Dao {
		
	Logger log = Logger.getRootLogger();
	
	public void createMember(Pojo pojo) throws SQLException{

		Connection conn = Connextion.getConnection();
		log.info("createMember called");
		log.info("Database Connection GET");
		
		String sql = "insert into fam_members (f_name, l_name, father_id, father_f_name, father_l_name, mother_id, mother_f_name, mother_l_name) values(?, ?, ?, ?, ?, ?, ?, ?)";
		
		//System.out.println(sql);
		
		String f_name = pojo.getfName();
		String l_name = pojo.getlName();
		int father_id = pojo.getFatherMemId();
		String father_f_name = pojo.getFatherFName();
		String father_l_name = pojo.getFatherLName();	
		int mother_id = pojo.getMotherMemId();
		String mother_f_name = pojo.getMotherFName();
		String mother_l_name = pojo.getMotherLName();
		
		
		try (PreparedStatement stmt = conn.prepareStatement(sql)){	
			stmt.setString(1, f_name);
			stmt.setString(2, l_name);
			stmt.setInt(3, father_id);
			stmt.setString(4, father_f_name);
			stmt.setString(5, father_l_name);
			stmt.setInt(6, mother_id);
			stmt.setString(7, mother_f_name);
			stmt.setString(8, mother_l_name);
			int row = stmt.executeUpdate();
			log.info(row + " rows updated.");
			conn.close();
		}
	}
	
	public Pojo retreiveMember(String fName, String lName) throws SQLException{

		Pojo pojo = new Pojo();
		Connection conn = Connextion.getConnection();
		log.info("retreiveMember called");
		log.info("Database Connection GET");
		
		String sql = "select mem_id, f_name, l_name, father_id, father_f_name, father_l_name, mother_id, mother_f_name, mother_l_name from fam_members where mem_id = (select mem_id from fam_members where f_name = ? and l_name = ?)";
				
		try (PreparedStatement stmt = conn.prepareStatement(sql)){	
			stmt.setString(1, fName);
			stmt.setString(2, lName);
			ResultSet r = stmt.executeQuery();
				if(r.next()) {
					
					pojo.setMemId(r.getInt(1));
					pojo.setfName(r.getString(2));
					pojo.setlName(r.getString(3));
					pojo.setFatherMemId(r.getInt(4));
					pojo.setFatherFName(r.getString(5));
					pojo.setFatherLName(r.getString(6));
					pojo.setMotherMemId(r.getInt(7));
					pojo.setMotherFName(r.getString(8));
					pojo.setMotherLName(r.getString(9));
				}
			conn.close();
		}
		
		
		
		
		
		
		
		//Fancy print out
		//System.out.println(pojo.getMemId());
		System.out.println(pojo.getFatherFName() +" "+pojo.getFatherLName() + "   ||   " + pojo.getMotherFName() +" "+ pojo.getMotherLName());
		System.out.println("         " + pojo.getfName()+" "+pojo.getlName());
		return pojo;
	}
	
	public void deleteMember(String fName, String lName) throws SQLException{

		Connection conn = Connextion.getConnection();
		log.info("deleteMember called");
		log.info("Database Connection GET");
		
		//String sql = "delete from fam_members where mem_id = (select mem_id from fam_members where f_name = ? and l_name = ?)";
		String sql = "delete from fam_members where f_name = ? and l_name = ?";
		try (PreparedStatement stmt = conn.prepareStatement(sql)){	
			stmt.setString(1, fName);
			stmt.setString(2, lName);
			int row = stmt.executeUpdate();
			log.info(row + " rows deleted.");
			conn.close();
		}
	}
	
	public void continueUpTree(Pojo pojo) throws SQLException{

		
		/*
		while(pojo.getFatherMemId()>0 && pojo.getMotherMemId()>0 ) {
			System.out.println("Father's Side");
			continueUpTree(retreiveMember(pojo.getFatherFName(),pojo.getFatherLName()));
		}
		while(pojo.getFatherMemId()>0 && pojo.getMotherMemId()>0 ) {
			
		}
		System.out.println("No further ancestors found.");
		
		//-------------------------------------------------
		*/
		 
		if(pojo.getFatherMemId()>0 && pojo.getMotherMemId()>0 ) {
			
			retreiveMember(pojo.getFatherFName(),pojo.getFatherLName());
			retreiveMember(pojo.getMotherFName(),pojo.getMotherLName());
		}else {
			System.out.println("No further ancestors found.");
		}
		
	}
}
