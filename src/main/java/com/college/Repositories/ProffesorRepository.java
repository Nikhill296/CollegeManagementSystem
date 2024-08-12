package com.college.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.college.Entities.Professors;

@Repository
public interface ProffesorRepository extends JpaRepository<Professors, Long> {

}
