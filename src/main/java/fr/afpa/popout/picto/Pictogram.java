package fr.afpa.popout.picto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "pictogram")

public class Pictogram {

	@Id @GeneratedValue
	@Column(name = "pictogram_id")
	private int id;
	
	@Column(name = "pictogram_name")
	private String name;

	public Pictogram(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
