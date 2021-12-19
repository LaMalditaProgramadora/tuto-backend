package pe.edu.upc.tutobackend.service;

import java.util.List;

import pe.edu.upc.tutobackend.model.Tutorship;

public interface TutorshipService {
	int save(Tutorship tutorship);
	List<Tutorship> list();
	Tutorship listById(int idTutorship);
}
