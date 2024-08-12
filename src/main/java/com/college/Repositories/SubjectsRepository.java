package com.college.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.college.Entities.Subjects;

public interface SubjectsRepository extends JpaRepository<Subjects, Long> {

	boolean findByTitle(Subjects subjects);

	boolean existsByTitle(String string);

    @Query("SELECT s.id FROM Subjects s WHERE s.title = :title")	
	Long findIdByTitle(@Param("title") String title);

}
