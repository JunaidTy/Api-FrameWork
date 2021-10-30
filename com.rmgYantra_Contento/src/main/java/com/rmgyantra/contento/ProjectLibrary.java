package com.rmgyantra.contento;

public class ProjectLibrary {
	//create global variables
	String createdBy;
	String projectName;
	String status;
	int teamSize;
	//initialize constructors
	public ProjectLibrary(String createdBy, String projectName, String status, int teamSize) {
	
		this.createdBy = createdBy;
		this.projectName = projectName;
		this.status = status;
		this.teamSize = teamSize;
	}
	//generate getters and setters
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getTeamSize() {
		return teamSize;
	}
	public void setTeamSize(int teamSize) {
		this.teamSize = teamSize;
	}
	
	
	
	

}
