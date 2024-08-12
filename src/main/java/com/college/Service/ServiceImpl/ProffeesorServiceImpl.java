package com.college.Service.ServiceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.college.DTO.ProfessorsDTO;
import com.college.DTO.SubjectsDTO;
import com.college.Entities.Professors;
import com.college.Entities.Subjects;
import com.college.Repositories.ProffesorRepository;
import com.college.Repositories.SubjectsRepository;
import com.college.Services.ProffesorService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProffeesorServiceImpl implements ProffesorService{

	private final ProffesorRepository professorsRepo;
	private final SubjectsRepository subjectsRepo;
	private final ModelMapper modelMapper;

	
	@Override
	public ProfessorsDTO addNewProffesor(ProfessorsDTO professorsDTO) {
		
		if(!professorsDTO.getSubjectsDTO().isEmpty()) {
			
			for(SubjectsDTO subjectsDTO : professorsDTO.getSubjectsDTO()) {
				
				if(subjectsRepo.existsByTitle(subjectsDTO.getTitle())) {
					
					subjectsDTO.setId(subjectsRepo.findIdByTitle(subjectsDTO.getTitle()));
				}
			}
		}
		
//		log.info("\n\n");
//		log.info(professorsDTO.toString());
//		log.info("\n\n");
		Professors professors = modelMapper.map(professorsDTO, Professors.class);
		Professors saved =  professorsRepo.save(professors);
//				professorsRepo.save(professors);
		
//		TODO : to write code for modelmapper and save professor
		return modelMapper.map(saved, ProfessorsDTO.class);
	}

	@Override
	public List<ProfessorsDTO> getAllProfessors() {
		List<Professors> professors = professorsRepo.findAll();
	    
	return professors.stream()
			.map(professor -> modelMapper.map(professor, ProfessorsDTO.class))
			.collect(Collectors.toList());
	}

	@Override
	public ProfessorsDTO assignSubjectToProffesor(Long subjectId, Long proffesorId) {
		Professors professors = professorsRepo.findById(proffesorId).orElseThrow();
		Subjects subject =  subjectsRepo.findById(subjectId).orElseThrow();
		
		
		List<Subjects> assignedSub = professors.getSubjects();
		assignedSub.add(subject);
		professors.setSubjects(assignedSub);

		Professors savedProfessors = professorsRepo.save(professors);
	    
		return modelMapper.map(savedProfessors, ProfessorsDTO.class);
	}

}
