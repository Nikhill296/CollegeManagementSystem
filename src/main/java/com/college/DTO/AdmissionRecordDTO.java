package com.college.DTO;


import org.hibernate.annotations.OnDelete;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AdmissionRecordDTO {
	
	private Long id;
	
	private int fees;
	
	private StudentsDTO studentDTO;

}


