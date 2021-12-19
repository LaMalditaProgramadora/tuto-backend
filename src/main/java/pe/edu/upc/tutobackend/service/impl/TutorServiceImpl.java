package pe.edu.upc.tutobackend.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.tutobackend.model.Tutor;
import pe.edu.upc.tutobackend.repository.TutorRepository;
import pe.edu.upc.tutobackend.service.TutorService;
import pe.edu.upc.tutobackend.util.Constants;

@Service
public class TutorServiceImpl implements TutorService {

	@Autowired
	private TutorRepository tutorRepository;

	@Override
	public int save(Tutor tutor) {
		Tutor tutorResult = tutorRepository.save(tutor);
		if (tutorResult != null)
			return tutorResult.getIdTutor();
		else
			return Constants.RESULT_ERROR_BD;
	}

	@Override
	public List<Tutor> list() {
		return tutorRepository.findAll();
	}

	@Override
	public Tutor listById(int idTutor) {
		return tutorRepository.getById(idTutor);
	}

}
