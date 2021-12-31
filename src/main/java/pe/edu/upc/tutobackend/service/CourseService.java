package pe.edu.upc.tutobackend.service;

import java.util.List;

import pe.edu.upc.tutobackend.model.Course;

public interface CourseService {
	int save(Course course);
	List<Course> list();
	Course listById(int idCourse);
	int deleteById(int idCourse);
}
