package com.prabathj.lc.dtomodels.support;

public class ModelAttributeDTO {
	private String courseName;
	private String courseType;
	
	
	public ModelAttributeDTO() {
		System.out.println("Inside ModelAttributeDTO");
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getCourseType() {
		return courseType;
	}
	public void setCourseType(String courseType) {
		this.courseType = courseType;
	}
	
	

}
