package pe.edu.upc.tutobackend.service;

import java.util.List;

import pe.edu.upc.tutobackend.model.Section;

public interface SectionService {
	int save(Section section);
	List<Section> list();
	Section listById(int idSection);
	int deleteById(int idSection);
}
