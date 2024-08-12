package com.college.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.college.Entities.Students;

@Repository
public interface StudentsRepository extends JpaRepository<Students, Long> {
	
	
}
