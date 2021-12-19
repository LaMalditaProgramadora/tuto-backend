package pe.edu.upc.tutobackend.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.tutobackend.model.Topic;
import pe.edu.upc.tutobackend.repository.TopicRepository;
import pe.edu.upc.tutobackend.service.TopicService;
import pe.edu.upc.tutobackend.util.Constants;

@Service
public class TopicServiceImpl implements TopicService {

	@Autowired
	private TopicRepository topicRepository;

	@Override
	public int save(Topic topic) {
		Topic topicResult = topicRepository.save(topic);
		if (topicResult != null)
			return topicResult.getIdTopic();
		else
			return Constants.RESULT_ERROR_BD;
	}

	@Override
	public List<Topic> list() {
		return topicRepository.findAll();
	}

	@Override
	public Topic listById(int idTopic) {
		return topicRepository.getById(idTopic);
	}

}
