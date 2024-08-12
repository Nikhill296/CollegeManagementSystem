package com.college.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.college.DTO.ProfessorsDTO;
import com.college.DTO.StudentsDTO;
import com.college.DTO.SubjectsDTO;
import com.college.Entities.Professors;
import com.college.Entities.Students;
import com.college.Entities.Subjects;
import com.college.Services.ProffesorService;
import com.college.Services.StudentService;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/College")
@RequiredArgsConstructor
public class CollegeController {
	
	Logger log = LoggerFactory.getLogger(CollegeController.class); 
	
	private final StudentService studentService; 
	private final ProffesorService proffesorService; 

	@PostMapping("/AddNewStudent")
	public ResponseEntity<StudentsDTO> getNewAdmission(@RequestBody StudentsDTO studentDto) {
		
		log.info("---------------- add new student ------------ ");
		
		StudentsDTO createdStudentDto = studentService.addNewAdmission(studentDto);
		
		return new ResponseEntity<StudentsDTO>(createdStudentDto,HttpStatus.CREATED);
	}
	
	@PostMapping("/AddNewProffesor")
	public ResponseEntity<ProfessorsDTO> addNewProffesor(@RequestBody ProfessorsDTO professorsDTO) {
		
		log.info("---------------- add new Proffesor ------------ ");
		
//		log.info(professorsDTO.toString());
		
		ProfessorsDTO createdProfessors = proffesorService.addNewProffesor(professorsDTO);
		
		return new ResponseEntity<ProfessorsDTO>(createdProfessors,HttpStatus.CREATED);
	}
	
	@PostMapping("/AddNewSubjects")
	public ResponseEntity<SubjectsDTO> addNewSubjects(@RequestBody SubjectsDTO subjectsDto) {
		
		log.info("---------------- add new Subjects ------------ ");
		
		SubjectsDTO createdSubjects = studentService.addNewSubjects(subjectsDto);
		
		return new ResponseEntity<SubjectsDTO>(createdSubjects,HttpStatus.CREATED);
	}
	
	@GetMapping("/getStudent/{studentId}")
	public ResponseEntity<StudentsDTO> getStudentInfo(@PathVariable Long studentId) {
		
		log.info("---------------- get added student ------------ ");
		
		StudentsDTO Student = studentService.getStudentInfo(studentId);
		
		return new ResponseEntity<StudentsDTO>(Student,HttpStatus.FOUND);
	}
	
	@GetMapping("/getStudent")
	public ResponseEntity<List<StudentsDTO>> getAllStudentInfo() {
		
		log.info("---------------- get all student ------------ ");
		
		List<StudentsDTO> Student = studentService.getAllStudentInfo();
		
		return new ResponseEntity<List<StudentsDTO>>(Student,HttpStatus.ACCEPTED);
	}
	

	
	@GetMapping("/getProfessors")
	public ResponseEntity<List<ProfessorsDTO>> getAllProfessors() {
		
		log.info("---------------- get all Professors ------------ ");
		
		List<ProfessorsDTO> professorsDTOs = proffesorService.getAllProfessors();
		return new ResponseEntity<List<ProfessorsDTO>>(professorsDTOs, HttpStatus.OK);
	}
	
	@GetMapping("/getAllSubjects")
	public ResponseEntity<List<SubjectsDTO>> getAllSubjects() {
		
		log.info("---------------- get all Subjects ------------ ");

		List<SubjectsDTO> subjects = studentService.getAllSubjects();
		
		return new ResponseEntity<List<SubjectsDTO>>(subjects,HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/AssignProfessor/{proffessorId}/ToStduent/{studentId}")
	public ResponseEntity<StudentsDTO> assignProfessor(@PathVariable Long proffessorId,
			                                         @PathVariable Long studentId){
		
		log.info("---------------- Assign Professor To Stduent ------------ ");

		
		StudentsDTO student = studentService.assignProffesorToStudent(proffessorId,studentId);
		
		return new ResponseEntity<StudentsDTO>(student,HttpStatus.OK);
		
	}
	
	@PutMapping("/AssignSubject/{subjectId}/ToStduent/{studentId}")
	public ResponseEntity<StudentsDTO> assignSubjectToStduent(@PathVariable Long subjectId,
			                                         @PathVariable Long studentId){
		
		log.info("---------------- Assign Subject To Stduent ------------ ");

		StudentsDTO student = studentService.assignSubjectToStduent(subjectId,studentId);
		
		return new ResponseEntity<StudentsDTO>(student,HttpStatus.OK);
		
	}
	
	@PutMapping("/AssignSubject/{subjectId}/ToProffesor/{proffesorId}")
	public ResponseEntity<ProfessorsDTO> assignSubjectToProffesor(@PathVariable Long subjectId,
			                                         @PathVariable Long proffesorId){
		log.info("---------------- Assign Subject To proffesor  ------------ ");

		ProfessorsDTO professors = proffesorService.assignSubjectToProffesor(subjectId,proffesorId);
		
		return new ResponseEntity<ProfessorsDTO>(professors,HttpStatus.OK);
		
	}
}
