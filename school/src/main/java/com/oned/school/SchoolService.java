package com.oned.school;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oned.school.client.StudentClient;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SchoolService {

	@Autowired
	private SchoolRepository repository;

	@Autowired
	private StudentClient studentClient;

	public void saveSchool(School school) {
		System.out.println(school.toString());
		repository.save(school);

	}

	public List<School> findAllSchools() {
		return repository.findAll();
	}

	public Optional<School> findSchoolById(Integer schoolId) {

		return repository.findById(schoolId);
	}

	public Object findSchoolsWithStudents(Integer schoolId) {

		var school = repository.findById(schoolId);
		//System.out.println("school ==== >" + school);

		var students = studentClient.findAllStudentsBySchool(schoolId);
		//System.out.println("students ==== >" + students);

		FullSchoolResponse resp = new FullSchoolResponse();
		
		resp.setName(school.get().getName());
		resp.setEmail(school.get().getEmail());

		
		resp.setStudents(students);

		return resp;
	}

	

}
