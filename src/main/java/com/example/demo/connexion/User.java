package com.example.demo.connexion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Digits;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.beans.support.MutableSortDefinition;
import org.springframework.beans.support.PropertyComparator;
import org.springframework.core.style.ToStringCreator;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import fr.afpa.popout.picto.Pictogram;

@Entity
@Table(name = "users")

public class User {
	@Column(name = "firstname")
	private String firstName;
	
	@Column(name = "lastname")
	private String lastName;
	
	@Column(name = "pseudo")
	private String pseudo;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "user_password")
	private String password;
	
	@Column(name = "city")
	private String city;
		
	@Column(name = "bio_light")
	private String bioLight;
	
	@Column(name = "bio")
	private String bio;
	
	@Column(name = "photo_name")
	private String photoName;
	
	@Column(name = "age")
	private int age;
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private Integer id;
	
//	@ManyToMany(fetch = FetchType.EAGER)
//	@JoinTable(name = "vet_specialties", joinColumns = @JoinColumn(name = "vet_id"), inverseJoinColumns = @JoinColumn(name = "specialty_id"))
//	private Set<Pictogram> userPicto;
//	
//	
//	public Set<Pictogram> getUserPicto() {
//		return userPicto;
//	}
//
//
//	public void setUserPicto(Set<Pictogram> userPicto) {
//		this.userPicto = userPicto;
//	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getBioLight() {
		return bioLight;
	}


	public void setBioLight(String bioLight) {
		this.bioLight = bioLight;
	}


	public String getPhotoName() {
		return photoName;
	}


	public void setPhotoName(String photoName) {
		this.photoName = photoName;
	}


	public String getPseudo() {
		return pseudo;
	}
	
	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	
	public String getBio() {
		return bio;
	}
	
	public void setBio(String bio) {
		this.bio = bio;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public boolean isNew() {
        return this.id == null;
    }
	
	 @Override
	    public String toString() {
	        return new ToStringCreator(this)

	            .append("id", this.getId())
	            .append("pseudo", this.getPseudo())
	            .append("lastName", this.getLastName())
	            .append("firstName", this.getFirstName())
	            .append("age", this.getAge())
	            .append("photo_name", this.getPhotoName())
	            .append("city", this.city)
	            .append("email", this.getEmail())
	            .append("bio_light", this.getBioLight())
	            .append("bio", this.getBio())
	            .toString();
	    }
	
}
