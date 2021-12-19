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
public class Tutor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idTutor;
	
	@Column(length = 10)
	private String code;
	
	@Column(length = 100)
	private String fullName;
	
	@OneToMany(mappedBy = "tutor")
	List<Tutorship> tutorships;
}
