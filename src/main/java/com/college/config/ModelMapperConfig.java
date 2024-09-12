package com.college.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.college.DTO.AdmissionRecordDTO;
import com.college.DTO.ProfessorsDTO;
import com.college.DTO.StudentsDTO;
import com.college.DTO.SubjectsDTO;
import com.college.Entities.AdmissionRecord;
import com.college.Entities.Professors;
import com.college.Entities.Students;
import com.college.Entities.Subjects;

@Configuration
public class ModelMapperConfig {

	@Bean
	public ModelMapper modelMapper() {
		ModelMapper modelMapper = new ModelMapper();

		// Custom mapping for nested object
		modelMapper.typeMap(Students.class, StudentsDTO.class).addMappings(mapper -> {
			mapper.map(Students::getAdmissiom, StudentsDTO::setAdmissiomDto);
			mapper.map(Students::getSubjects, StudentsDTO::setSubjectsDTO);
			mapper.map(Students::getProfessors, StudentsDTO::setProfessorsDTO);
		});

		// Custom mapping for nested object
//		modelMapper.typeMap(StudentsDTO.class, Students.class).addMappings(mapper -> {
//			mapper.map(StudentsDTO::getAdmissiomDto, Students::setAdmissiom);
//			mapper.map(StudentsDTO::getSubjectsDTO, Students::setSubjects);
//			mapper.map(StudentsDTO::getSubjectsDTO, Students::setSubjects);
//		});

//		modelMapper.createTypeMap(SubjectsDTO.class, Subjects.class)
//	    .addMappings(mapper -> {
//	    	modelMapper.map(SubjectsDTO.class, Subjects.class);
//	    });
//	
//		modelMapper.createTypeMap(Subjects.class, SubjectsDTO.class)
//	    .addMappings(mapper -> {
//	    	modelMapper.map(Subjects.class, SubjectsDTO.class);
//	    });

//		modelMapper.typeMap(SubjectsDTO.class, Subjects.class).setConverter(context -> {
//			SubjectsDTO subjectsDTO = context.getSource();
//			return modelMapper.map(subjectsDTO, Subjects.class);
//		});
//	
//
//		modelMapper.typeMap(Subjects.class, SubjectsDTO.class).setConverter(context -> {
//			Subjects subjects = context.getSource();
//			return modelMapper.map(subjects, SubjectsDTO.class);
//		});
//		
//		modelMapper.typeMap(AdmissionRecord.class, AdmissionRecordDTO.class).setConverter(context ->{
//			AdmissionRecord admissionRecord = context.getSource();
//			return modelMapper.map(admissionRecord,AdmissionRecordDTO.class);
//		});
//		
//
//		modelMapper.typeMap(AdmissionRecordDTO.class, AdmissionRecord.class).setConverter(context ->{
//			AdmissionRecordDTO admissionRecordDTO = context.getSource();
//			return modelMapper.map(admissionRecordDTO,AdmissionRecord.class);
//			
//		});
//		
//		modelMapper.typeMap(StudentsDTO.class, Students.class).setConverter(context -> {
//			StudentsDTO studentsDTO = context.getSource();
//			return modelMapper.map(studentsDTO, Students.class);
//		});
//	
//
//		modelMapper.typeMap(Students.class, StudentsDTO.class).setConverter(context -> {
//			Students students = context.getSource();
//			return modelMapper.map(students, StudentsDTO.class);
//		});

		return modelMapper;
	}

}
