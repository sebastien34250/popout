package com.example.demo.connexion;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

import java.util.List;

@Entity
@Table(name="events")
public class Event {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="event_id")
	@NotEmpty
	private int event_id;
	
	@Column(name="title")
	private String title;
	
	@Column(name="event_date")
	private String event_date;
	
	@Column(name="city")
	private String city;
	
	@Column(name="master_id")
	private User master_id;
	
	@Column(name="start_time")
	private String start_time;
	
	@Column(name="end_time")
	private String end_time;
	
	@Column(name="bio_light")
	private String bio_light;
	
	@Column(name="bio")
	private String bio;
	
	@Column(name="photo_name")
	private String photo_name;
	
	@ManyToMany
	@JoinTable(name="event_pictograms", joinColumns = @JoinColumn(name = "event_id"), inverseJoinColumns = @JoinColumn(name = "pictogram_id"))
	private List<Pictogram> eventPicto;
	
	//private List<Comment> eventComment;
	
	@ManyToMany
	@JoinTable(name="event_users", joinColumns = @JoinColumn(name = "event_id"), inverseJoinColumns = @JoinColumn(name = "user_id"))
	private List<User> eventParticipant;

	
	
	
	public int getEvent_id() {
		return event_id;
	}

	public void setEvent_id(int event_id) {
		this.event_id = event_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getEvent_date() {
		return event_date;
	}

	public void setEvent_date(String event_date) {
		this.event_date = event_date;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public User getMaster_id() {
		return master_id;
	}

	public void setMaster_id(User master_id) {
		this.master_id = master_id;
	}

	public String getStart_time() {
		return start_time;
	}

	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}

	public String getEnd_time() {
		return end_time;
	}

	public void setEnd_time(String end_time) {
		this.end_time = end_time;
	}

	public String getBio_light() {
		return bio_light;
	}

	public void setBio_light(String bio_light) {
		this.bio_light = bio_light;
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	public String getPhoto_name() {
		return photo_name;
	}

	public void setPhoto_name(String photo_name) {
		this.photo_name = photo_name;
	}

	public List<Pictogram> getEventPicto() {
		return eventPicto;
	}

	public void setEventPicto(List<Pictogram> eventPicto) {
		this.eventPicto = eventPicto;
	}

	public List<User> getEventParticipant() {
		return eventParticipant;
	}

	public void setEventParticipant(List<User> eventParticipant) {
		this.eventParticipant = eventParticipant;
	}
	
}
