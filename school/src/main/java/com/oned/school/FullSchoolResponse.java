package com.oned.school;

import java.util.List;

import lombok.Builder;

@Builder
public class FullSchoolResponse {
	
	private String name;
	private String email;
	
	List<Student> students;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public FullSchoolResponse() {
		super();
	}

	public FullSchoolResponse(String name, String email, List<Student> students) {
		super();
		this.name = name;
		this.email = email;
		this.students = students;
	}

	@Override
	public String toString() {
		return "FullSchoolResponse [name=" + name + ", email=" + email + ", students=" + students + "]";
	}
	
	

}
