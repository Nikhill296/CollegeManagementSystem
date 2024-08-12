package com.college.Services;

import java.util.List;

import com.college.DTO.StudentsDTO;
import com.college.DTO.SubjectsDTO;
import com.college.Entities.Students;
import com.college.Entities.Subjects;

public interface StudentService {
	public final int COURSE_FEES = 8000;
	
	StudentsDTO addNewAdmission(StudentsDTO studentDto);

	StudentsDTO getStudentInfo(Long studentId);

	List<StudentsDTO> getAllStudentInfo();

	StudentsDTO assignProffesorToStudent(Long proffessorId, Long studentId);

	StudentsDTO assignSubjectToStduent(Long subjectId, Long studentId);

	List<SubjectsDTO> getAllSubjects();

	SubjectsDTO addNewSubjects(SubjectsDTO subjectsDto);
	

}
