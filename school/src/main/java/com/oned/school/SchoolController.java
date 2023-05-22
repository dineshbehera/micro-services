package com.oned.school;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/schools")
@RequiredArgsConstructor
public class SchoolController {
	
	@Autowired
	private SchoolService service;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void save(@RequestBody School school) {
		System.out.println("==== >"+school.toString());
	
		service.saveSchool(school);
	}
	
	@GetMapping
    public ResponseEntity<List<School>> findAllSchools() {
        return ResponseEntity.ok(service.findAllSchools());
    }
	
	@GetMapping("/{school-id}")
    public ResponseEntity<Optional<School>> findAllSchoolById(@PathVariable("school-id") Integer schoolId) {
		System.out.println("/GET called for /"+schoolId);
        return ResponseEntity.ok(service.findSchoolById(schoolId));
    }
	
	@GetMapping("/{school-id}/students")
	public ResponseEntity<Object> findAllSchools(@PathVariable("school-id") Integer schoolId) {
		System.out.println("GET /"+schoolId+"/students");
		return ResponseEntity.ok(service.findSchoolsWithStudents(schoolId));
	}
	

}
