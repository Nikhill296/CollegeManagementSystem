package com.college.Repositories;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.college.Entities.Subjects;

import jakarta.transaction.Transactional;

public interface SubjectsRepository extends JpaRepository<Subjects, Long> {

	ArrayList<Subjects> findByTitle(String string);

    @Query("SELECT s FROM Subjects s WHERE s.title in :title and s.stdcount = :string")	
	ArrayList<Subjects> findByTitlessss(@Param("title") ArrayList<String> title, @Param("string") String string);
	
	boolean existsByTitle(String string);

    @Query("SELECT s.id FROM Subjects s WHERE s.title = :title")	
	Long findIdByTitle(@Param("title") String title);

	ArrayList<Subjects> findByTitleInAndStdcount(ArrayList<String> title, String string);
    
//    @Modifying
//    @Transactional
//    @Query("update Subjects set marks='100' WHERE marks = :marks")
//    int UpdateByTitle(@Param("title") Integer marks);

//  @Modifying
//  @Transactional
//	Subjects saveByTitleAndMarks(Subjects subjects1, String string, Integer marks);



}
