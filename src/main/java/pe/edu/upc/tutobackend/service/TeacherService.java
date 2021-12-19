package pe.edu.upc.tutobackend.service;

import java.util.List;

import pe.edu.upc.tutobackend.model.Teacher;

public interface TeacherService {
	int save(Teacher teacher);
	List<Teacher> list();
	Teacher listById(int idTeacher);
}
