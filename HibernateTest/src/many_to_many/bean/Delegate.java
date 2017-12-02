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
@Table(name="Delegate")
public class Delegate {
	
	@Id
	@GeneratedValue
	private int delegateId;
	
	@Column
	private String name;
	
	@ManyToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinTable(name="Event_Delegats",joinColumns={@JoinColumn(name="delegateId")},inverseJoinColumns={@JoinColumn(name="eventId")})
	private List<Event> events;

	public int getId() {
		return delegateId;
	}

	public void setId(int id) {
		this.delegateId = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Event> getEvents() {
		return events;
	}

	public void setEvents(List<Event> events) {
		this.events = events;
	}

}
