package pe.edu.upc.tutobackend.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.tutobackend.model.Section;
import pe.edu.upc.tutobackend.repository.SectionRepository;
import pe.edu.upc.tutobackend.service.SectionService;
import pe.edu.upc.tutobackend.util.Constants;

@Service
public class SectionServiceImpl implements SectionService {

	@Autowired
	private SectionRepository sectionRepository;

	@Override
	public int save(Section section) {
		Section sectionResult = sectionRepository.save(section);
		if (sectionResult != null)
			return sectionResult.getIdSection();
		else
			return Constants.RESULT_ERROR_BD;
	}

	@Override
	public List<Section> list() {
		return sectionRepository.findAll();
	}

	@Override
	public Section listById(int idSection) {
		return sectionRepository.getById(idSection);
	}

}
