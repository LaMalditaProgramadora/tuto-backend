package pe.edu.upc.tutobackend.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Topic {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idTopic;
	
	@Column(length = 60)
	private String description;
	
	@OneToMany(mappedBy = "topic")
	private List<Tutorship> tutorships;
}
