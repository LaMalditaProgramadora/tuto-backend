package pe.edu.upc.tutobackend.service;

import java.util.List;

import pe.edu.upc.tutobackend.model.Tutor;

public interface TutorService {
	int save(Tutor tutor);
	List<Tutor> list();
	Tutor listById(int idTutor);
}
