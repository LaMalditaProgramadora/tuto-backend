package pe.edu.upc.tutobackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.tutobackend.model.Topic;

@Repository
public interface TopicRepository extends JpaRepository<Topic, Integer> {

}
