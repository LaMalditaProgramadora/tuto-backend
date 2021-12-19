package pe.edu.upc.tutobackend.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.tutobackend.model.Course;
import pe.edu.upc.tutobackend.repository.CourseRepository;
import pe.edu.upc.tutobackend.service.CourseService;
import pe.edu.upc.tutobackend.util.Constants;

@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	private CourseRepository courseRepository;

	@Override
	public int save(Course course) {
		Course courseResult = courseRepository.save(course);
		if (courseResult != null)
			return courseResult.getIdCourse();
		else
			return Constants.RESULT_ERROR_BD;
	}

	@Override
	public List<Course> list() {
		return courseRepository.findAll();
	}

	@Override
	public Course listById(int idCourse) {
		return courseRepository.getById(idCourse);
	}

}
