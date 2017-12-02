package one_two_many.bean;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="Collage")
public class Collage {
	
	@Id
	@GeneratedValue
	private int collageId;
	
	@Column
	private String collageName;
	
	@OneToMany(targetEntity=Student.class,mappedBy="collage",cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	private List<Student> students;

	public int getCollageId() {
		return collageId;
	}

	public void setCollageId(int collageId) {
		this.collageId = collageId;
	}

	public String getCollageName() {
		return collageName;
	}

	public void setCollageName(String collageName) {
		this.collageName = collageName;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

}
