package pe.edu.upc.tutobackend.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Section {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idSection;

	@Column(length = 10)
	private String code;
	
	@Column(length = 10)
	private String period;

	@ManyToOne
	@JoinColumn(name = "idTeacher", nullable = false)
	private Teacher teacher;

	@ManyToOne
	@JoinColumn(name = "idCourse", nullable = false)
	private Course course;

	@ManyToMany(mappedBy = "sections")
	private List<Student> students;

}
