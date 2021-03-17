package com.famtr;

public class Pojo {
	private int memId;
	private String fName;
	private String lName;
	private int fatherMemId;
	private String fatherFName;
	private String fatherLName;
	private int motherMemId;
	private String motherFName;
	private String motherLName;
	
	public int getMemId() {
		return memId;
	}
	public void setMemId(int memId) {
		this.memId = memId;
	}
	
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	public int getFatherMemId() {
		return fatherMemId;
	}
	public void setFatherMemId(int fatherMemId) {
		this.fatherMemId = fatherMemId;
	}
	public String getFatherFName() {
		return fatherFName;
	}
	public void setFatherFName(String fatherFName) {
		this.fatherFName = fatherFName;
	}
	public String getFatherLName() {
		return fatherLName;
	}
	public void setFatherLName(String fatherLName) {
		this.fatherLName = fatherLName;
	}
	public int getMotherMemId() {
		return motherMemId;
	}
	public void setMotherMemId(int motherMemId) {
		this.motherMemId = motherMemId;
	}
	public String getMotherFName() {
		return motherFName;
	}
	public void setMotherFName(String motherFName) {
		this.motherFName = motherFName;
	}
	public String getMotherLName() {
		return motherLName;
	}
	public void setMotherLName(String motherLName) {
		this.motherLName = motherLName;
	}
	public Pojo(String fName, String lName, int fatherMemId, String fatherFName, String fatherLName,
			int motherMemId, String motherFName, String motherLName) {
		super();
		this.memId = 0;
		this.fName = fName;
		this.lName = lName;
		this.fatherMemId = fatherMemId;
		this.fatherFName = fatherFName;
		this.fatherLName = fatherLName;
		this.motherMemId = motherMemId;
		this.motherFName = motherFName;
		this.motherLName = motherLName;
	}
	
	public Pojo() {}
	
}
