package pe.edu.upc.tutobackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.upc.tutobackend.dto.ResponseDto;
import pe.edu.upc.tutobackend.model.Student;
import pe.edu.upc.tutobackend.service.StudentService;
import pe.edu.upc.tutobackend.util.Constants;

@CrossOrigin
@RestController
@RequestMapping(path = "/student")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@GetMapping(path = "/list", produces = "application/json")
	public ResponseEntity<?> list() {
		List<Student> students = studentService.list();
		return ResponseEntity.ok(students);
	}

	@GetMapping(path = "/listById", produces = "application/json")
	public ResponseEntity<?> listById(@RequestParam int idStudent) {
		Student student = studentService.listById(idStudent);
		return ResponseEntity.ok(student);
	}

	@PostMapping(path = "/save", consumes = "application/json", produces = "application/json")
	public ResponseEntity<?> save(@RequestBody Student student) {
		int result = studentService.save(student);
		ResponseDto response = new ResponseDto();
		response.setIdResponse(result);
		if (result == Constants.RESULT_ERROR_BD) {
			response.setMessage("Error al guardar");
			return ResponseEntity.ok(response);
		} else {
			Student studentCreate = studentService.listById(result);
			return ResponseEntity.ok(studentCreate);
		}
	}
	
	@DeleteMapping(path = "/delete", produces = "application/json")
	public ResponseEntity<?> deleteById(@RequestParam int idStudent) {
		int result = studentService.deleteById(idStudent);
		ResponseDto response = new ResponseDto();
		response.setIdResponse(result);
		if (result == Constants.RESULT_ERROR_BD) {
			response.setMessage("Error al eliminar");
		} else {
			response.setMessage("Eliminación exitosa");
		}
		return ResponseEntity.ok(response);
	}
}
