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
import pe.edu.upc.tutobackend.model.Tutorship;
import pe.edu.upc.tutobackend.service.TutorshipService;
import pe.edu.upc.tutobackend.util.Constants;

@CrossOrigin
@RestController
@RequestMapping(path = "/tutorship")
public class TutorshipController {

	@Autowired
	private TutorshipService tutorshipService;

	@GetMapping(path = "/list", produces = "application/json")
	public ResponseEntity<?> list() {
		List<Tutorship> tutorships = tutorshipService.list();
		return ResponseEntity.ok(tutorships);
	}

	@GetMapping(path = "/listById", produces = "application/json")
	public ResponseEntity<?> listById(@RequestParam int idTutorship) {
		Tutorship tutorship = tutorshipService.listById(idTutorship);
		return ResponseEntity.ok(tutorship);
	}

	@PostMapping(path = "/save", consumes = "application/json", produces = "application/json")
	public ResponseEntity<?> save(@RequestBody Tutorship tutorship) {
		int result = tutorshipService.save(tutorship);
		ResponseDto response = new ResponseDto();
		response.setIdResponse(result);
		if (result == Constants.RESULT_ERROR_BD) {
			response.setMessage("Error al guardar");
			return ResponseEntity.ok(response);
		} else {
			Tutorship tutorshipCreate = tutorshipService.listById(result);
			return ResponseEntity.ok(tutorshipCreate);
		}
	}
	
	@DeleteMapping(path = "/delete", produces = "application/json")
	public ResponseEntity<?> deleteById(@RequestParam int idTutorship) {
		int result = tutorshipService.deleteById(idTutorship);
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
