package pe.edu.upc.tutobackend.service;

import java.util.List;

import pe.edu.upc.tutobackend.model.Topic;

public interface TopicService {
	int save(Topic topic);
	List<Topic> list();
	Topic listById(int idTopic);
	int deleteById(int idTopic);
}
