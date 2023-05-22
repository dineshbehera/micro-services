package com.oned.school.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.oned.school.Student;

@FeignClient(name = "student-service", url = "http://localhost:8090/api/v1/students")
public interface StudentClient {
	
	@GetMapping("/school/{school-id}")
	List<Student> findAllStudentsBySchool(@PathVariable("school-id") Integer schoolId);
}
