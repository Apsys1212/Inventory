package many_to_many.bean;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="Event")
public class Event {
	
	@Id
	@GeneratedValue
	private int eventId;
	
	@Column
	private String name;
	
	@ManyToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinTable(name="Event_Delegats",joinColumns={@JoinColumn(name="eventId")},inverseJoinColumns={@JoinColumn(name="delegateId")})
	private List<Delegate> delegates;

	public int getId() {
		return eventId;
	}

	public void setId(int id) {
		this.eventId = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Delegate> getDelegates() {
		return delegates;
	}

	public void setDelegates(List<Delegate> delegates) {
		this.delegates = delegates;
	}

	
}
