package pe.edu.upc.tutobackend.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idStudent;
	
	@Column(length = 10)
	private String code;
	
	@Column(length = 100)
	private String fullName;
	
	@ManyToMany
	@JoinTable(
	  name = "student_section", 
	  joinColumns = @JoinColumn(name = "idStudent"), 
	  inverseJoinColumns = @JoinColumn(name = "idSection"))
	private List<Section> sections;
	
	@OneToMany(mappedBy = "student")
	private List<Tutorship> tutorships;
}
