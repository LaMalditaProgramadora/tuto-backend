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
import pe.edu.upc.tutobackend.model.Topic;
import pe.edu.upc.tutobackend.service.TopicService;
import pe.edu.upc.tutobackend.util.Constants;

@CrossOrigin
@RestController
@RequestMapping(path = "/topic")
public class TopicController {

	@Autowired
	private TopicService topicService;

	@GetMapping(path = "/list", produces = "application/json")
	public ResponseEntity<?> list() {
		List<Topic> topics = topicService.list();
		return ResponseEntity.ok(topics);
	}

	@GetMapping(path = "/listById", produces = "application/json")
	public ResponseEntity<?> listById(@RequestParam int idTopic) {
		Topic topic = topicService.listById(idTopic);
		return ResponseEntity.ok(topic);
	}

	@PostMapping(path = "/save", consumes = "application/json", produces = "application/json")
	public ResponseEntity<?> save(@RequestBody Topic topic) {
		int result = topicService.save(topic);
		ResponseDto response = new ResponseDto();
		response.setIdResponse(result);
		if (result == Constants.RESULT_ERROR_BD) {
			response.setMessage("Error al guardar");
			return ResponseEntity.ok(response);
		} else {
			Topic topicCreate = topicService.listById(result);
			return ResponseEntity.ok(topicCreate);
		}
	}
	
	@DeleteMapping(path = "/delete", produces = "application/json")
	public ResponseEntity<?> deleteById(@RequestParam int idTopic) {
		int result = topicService.deleteById(idTopic);
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
