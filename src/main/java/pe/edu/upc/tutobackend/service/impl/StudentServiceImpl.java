package pe.edu.upc.tutobackend.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.tutobackend.model.Student;
import pe.edu.upc.tutobackend.repository.StudentRepository;
import pe.edu.upc.tutobackend.service.StudentService;
import pe.edu.upc.tutobackend.util.Constants;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepository;

	@Override
	public int save(Student student) {
		Student studentResult = studentRepository.save(student);
		if (studentResult != null)
			return studentResult.getIdStudent();
		else
			return Constants.RESULT_ERROR_BD;
	}

	@Override
	public List<Student> list() {
		return studentRepository.findAll();
	}

	@Override
	public Student listById(int idStudent) {
		return studentRepository.findById(idStudent).get();
	}
	
	@Override
	public int deleteById(int idStudent) {
		try {
			studentRepository.deleteById(idStudent);
			return Constants.RESULT_OK;
		} catch (Exception e) {
			return Constants.RESULT_ERROR_BD;
		}
	}

}
