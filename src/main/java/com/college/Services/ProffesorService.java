package com.college.Services;

import java.util.List;

import com.college.DTO.ProfessorsDTO;
import com.college.Entities.Professors;
import com.college.Entities.Students;

public interface ProffesorService {

	ProfessorsDTO addNewProffesor(ProfessorsDTO professorsDTO);

	List<ProfessorsDTO> getAllProfessors();

	ProfessorsDTO assignSubjectToProffesor(Long subjectId, Long proffesorId);

}
