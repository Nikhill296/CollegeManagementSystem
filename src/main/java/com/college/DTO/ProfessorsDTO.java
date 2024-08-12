package com.college.DTO;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ProfessorsDTO {
	
	private Long id;

	private String title;

	private List<StudentsDTO> studentsDTOs; 
	
	private List<SubjectsDTO> subjectsDTO;
	


}
