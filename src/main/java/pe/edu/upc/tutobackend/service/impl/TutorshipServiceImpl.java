package pe.edu.upc.tutobackend.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.tutobackend.model.Tutorship;
import pe.edu.upc.tutobackend.repository.TutorshipRepository;
import pe.edu.upc.tutobackend.service.TutorshipService;
import pe.edu.upc.tutobackend.util.Constants;

@Service
public class TutorshipServiceImpl implements TutorshipService {

	@Autowired
	private TutorshipRepository tutorshipRepository;

	@Override
	public int save(Tutorship tutorship) {
		Tutorship tutorshipResult = tutorshipRepository.save(tutorship);
		if (tutorshipResult != null)
			return tutorshipResult.getIdTutorship();
		else
			return Constants.RESULT_ERROR_BD;
	}

	@Override
	public List<Tutorship> list() {
		return tutorshipRepository.findAll();
	}

	@Override
	public Tutorship listById(int idTutorship) {
		return tutorshipRepository.findById(idTutorship).get();
	}

	@Override
	public int deleteById(int idTutorship) {
		try {
			tutorshipRepository.deleteById(idTutorship);
			return Constants.RESULT_OK;
		} catch (Exception e) {
			return Constants.RESULT_ERROR_BD;
		}
	}
}
