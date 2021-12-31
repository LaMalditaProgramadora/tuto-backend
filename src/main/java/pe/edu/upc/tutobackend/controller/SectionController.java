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
import pe.edu.upc.tutobackend.model.Section;
import pe.edu.upc.tutobackend.service.SectionService;
import pe.edu.upc.tutobackend.util.Constants;

@CrossOrigin
@RestController
@RequestMapping(path = "/section")
public class SectionController {

	@Autowired
	private SectionService sectionService;

	@GetMapping(path = "/list", produces = "application/json")
	public ResponseEntity<?> list() {
		List<Section> sections = sectionService.list();
		return ResponseEntity.ok(sections);
	}

	@GetMapping(path = "/listById", produces = "application/json")
	public ResponseEntity<?> listById(@RequestParam int idSection) {
		Section section = sectionService.listById(idSection);
		return ResponseEntity.ok(section);
	}

	@PostMapping(path = "/save", consumes = "application/json", produces = "application/json")
	public ResponseEntity<?> save(@RequestBody Section section) {
		int result = sectionService.save(section);
		ResponseDto response = new ResponseDto();
		response.setIdResponse(result);
		if (result == Constants.RESULT_ERROR_BD) {
			response.setMessage("Error al guardar");
			return ResponseEntity.ok(response);
		} else {
			Section sectionCreate = sectionService.listById(result);
			return ResponseEntity.ok(sectionCreate);
		}
	}
	
	@DeleteMapping(path = "/delete", produces = "application/json")
	public ResponseEntity<?> deleteById(@RequestParam int idSection) {
		int result = sectionService.deleteById(idSection);
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
