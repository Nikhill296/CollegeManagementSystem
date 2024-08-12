package com.college.DTO;

import java.util.List;

import com.college.Entities.AdmissionRecord;
import com.college.Entities.Professors;
import com.college.Entities.Subjects;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.Data;
import lombok.Getter;



@Getter
@Setter
@ToString
public class StudentsDTO {

	private Long id;
	
	private String name;
	
	private List<ProfessorsDTO> professorsDTO;
	
	private List<SubjectsDTO> subjectsDTO;
	
	private AdmissionRecordDTO admissiomDto;

	
}
