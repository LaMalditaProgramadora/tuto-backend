package pe.edu.upc.tutobackend.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Tutorship {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idTutorship;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
	private Date date;
	
	private boolean attended;
	
	private String reason;
	
	private String solution;
	
	@ManyToOne
	@JoinColumn(name = "idTutor", nullable = false)
	private Tutor tutor;
	
	@ManyToOne
	@JoinColumn(name = "idStudent", nullable = false)
	private Student student;
	
	@ManyToOne
	@JoinColumn(name = "idTopic", nullable = false)
	private Topic topic;
}
