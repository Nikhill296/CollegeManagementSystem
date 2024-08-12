package com.college.DTO;

import java.util.List;

import lombok.Data;
import lombok.ToString;


@Data
@ToString
public class SubjectsDTO {
	
	
	private Long id;
	
	private String title;

	
	private List<StudentsDTO> studentsDTO; 
	
	private List<ProfessorsDTO> professorsDTO; 

}
