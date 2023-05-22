package com.oned.student;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StudentService {
	
	@Autowired
	StudentRepository repository;
	
	public void saveStudent(Student student) {
		repository.save(student);
		
	}
	
	public List<Student> findAllStudents() {
		return repository.findAll();
	}

	public List<Student> findAllStudentsBySchool(Integer schoolId) {
		// TODO Auto-generated method stub
		return repository.findAllBySchoolId(schoolId);
	}

}
