package com.oned.school;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SchoolRepository extends JpaRepository<School, Integer>{
	
	Optional<School> findById(Integer schoolId);

}
