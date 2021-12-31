package pe.edu.upc.tutobackend.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.tutobackend.model.Teacher;
import pe.edu.upc.tutobackend.repository.TeacherRepository;
import pe.edu.upc.tutobackend.service.TeacherService;
import pe.edu.upc.tutobackend.util.Constants;

@Service
public class TeacherServiceImpl implements TeacherService {

	@Autowired
	private TeacherRepository teacherRepository;

	@Override
	public int save(Teacher teacher) {
		Teacher teacherResult = teacherRepository.save(teacher);
		if (teacherResult != null)
			return teacherResult.getIdTeacher();
		else
			return Constants.RESULT_ERROR_BD;
	}

	@Override
	public List<Teacher> list() {
		return teacherRepository.findAll();
	}

	@Override
	public Teacher listById(int idTeacher) {
		return teacherRepository.findById(idTeacher).get();
	}

	@Override
	public int deleteById(int idTeacher) {
		try {
			teacherRepository.deleteById(idTeacher);
			return Constants.RESULT_OK;
		} catch (Exception e) {
			return Constants.RESULT_ERROR_BD;
		}
	}
	
}
