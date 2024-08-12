package com.college.Service.ServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.security.auth.Subject;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.college.Repositories.ProffesorRepository;
import com.college.Repositories.StudentsRepository;
import com.college.Repositories.SubjectsRepository;
import com.college.Services.StudentService;
import com.college.DTO.StudentsDTO;
import com.college.DTO.SubjectsDTO;
import com.college.Entities.*;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

	Logger log = LoggerFactory.getLogger(StudentServiceImpl.class); 

	private final StudentsRepository studentRepo;
	private final ProffesorRepository proffessorRepo;
	private final AdmissionRecordRepository admissionRepo;
	private final SubjectsRepository subjectsRepo;
	private final ModelMapper modelMapper;  
	
	@Override
	public StudentsDTO addNewAdmission(StudentsDTO studentDto) {

		
		Students student = modelMapper.map(studentDto, Students.class);
		AdmissionRecord admissionRecord = new AdmissionRecord();
		admissionRecord.setFees(StudentService.COURSE_FEES);
		
		student.setAdmissiom(admissionRecord);
		Students savedStd =  studentRepo.save(student);
		
		return modelMapper.map(savedStd, StudentsDTO.class);
	}

	@Override
	public StudentsDTO getStudentInfo(Long studentId) {
		Students student = studentRepo.findById(studentId).orElseThrow();
		log.info("student admission >>> "+ student.getAdmissiom().getId());
		return modelMapper.map(student, StudentsDTO.class);
	}

	@Override
	public List<StudentsDTO> getAllStudentInfo() {
		
		log.info(" in getAllStudentInfo method to get all students ");
		List<Students> students = studentRepo.findAll();
		
		log.info(" students 1 >>> " + students.get(0).getProfessors().toString());

//		log.info(" All Students = {} " +students.toString()); 
		
		List<StudentsDTO> savedStdDto = 
				students
					.stream()
					.map((student) -> modelMapper.map(student, StudentsDTO.class))
					.collect(Collectors.toList());
		
		savedStdDto.forEach(stdentDto -> log.info("Dto ::: "+stdentDto.toString()));
		
//        log.info(" All StudentsDtos  = "+ savedStdDto.toString()); 

		
		return savedStdDto;
	}

	@Override
	public StudentsDTO assignProffesorToStudent(Long proffessorId, Long studentId) {

		Professors proffesor = proffessorRepo.findById(proffessorId).orElseThrow();
		Students student = studentRepo.findById(studentId).orElseThrow();
	
		List<Professors> profeList = student.getProfessors();
		profeList.add(proffesor);
		
		student.setProfessors(profeList);
		
		Students savedStudent = studentRepo.save(student);
		
		return modelMapper.map(savedStudent, StudentsDTO.class);
	}

	@Override
	public StudentsDTO assignSubjectToStduent(Long subjectId, Long studentId) {
		Students student = studentRepo.findById(studentId).orElseThrow();
		Subjects subject =  subjectsRepo.findById(subjectId).orElseThrow();
		
		List<Subjects> assignedSub = student.getSubjects();
		assignedSub.add(subject);
		student.setSubjects(assignedSub);

		Students savedStudent = studentRepo.save(student);
	    
		return modelMapper.map(savedStudent, StudentsDTO.class);
	}

	@Override
	public List<SubjectsDTO> getAllSubjects() {
		List<Subjects> allSub = subjectsRepo.findAll();
		
		return allSub.stream()
				.map(sub -> modelMapper.map(sub, SubjectsDTO.class))
				.collect(Collectors.toList());
	}

	@Override
	public SubjectsDTO addNewSubjects(SubjectsDTO subjectsDTO) {
	
		Subjects subjects = modelMapper.map(subjectsDTO, Subjects.class); 		
		Subjects saved =  subjectsRepo.save(subjects);
		 
		 return modelMapper.map(saved, SubjectsDTO.class);
	}

}
