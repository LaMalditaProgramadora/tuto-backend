package pe.edu.upc.tutobackend.service;

import java.util.List;

import pe.edu.upc.tutobackend.model.Student;

public interface StudentService {
	int save(Student student);
	List<Student> list();
	Student listById(int idStudent);
}
