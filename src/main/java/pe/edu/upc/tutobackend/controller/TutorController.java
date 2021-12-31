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
import pe.edu.upc.tutobackend.model.Tutor;
import pe.edu.upc.tutobackend.service.TutorService;
import pe.edu.upc.tutobackend.util.Constants;

@CrossOrigin
@RestController
@RequestMapping(path = "/tutor")
public class TutorController {

	@Autowired
	private TutorService tutorService;

	@GetMapping(path = "/list", produces = "application/json")
	public ResponseEntity<?> list() {
		List<Tutor> tutors = tutorService.list();
		return ResponseEntity.ok(tutors);
	}

	@GetMapping(path = "/listById", produces = "application/json")
	public ResponseEntity<?> listById(@RequestParam int idTutor) {
		Tutor tutor = tutorService.listById(idTutor);
		return ResponseEntity.ok(tutor);
	}

	@PostMapping(path = "/save", consumes = "application/json", produces = "application/json")
	public ResponseEntity<?> save(@RequestBody Tutor tutor) {
		int result = tutorService.save(tutor);
		ResponseDto response = new ResponseDto();
		response.setIdResponse(result);
		if (result == Constants.RESULT_ERROR_BD) {
			response.setMessage("Error al guardar");
			return ResponseEntity.ok(response);
		} else {
			Tutor tutorCreate = tutorService.listById(result);
			return ResponseEntity.ok(tutorCreate);
		}
	}
	
	@DeleteMapping(path = "/delete", produces = "application/json")
	public ResponseEntity<?> deleteById(@RequestParam int idTutor) {
		int result = tutorService.deleteById(idTutor);
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
