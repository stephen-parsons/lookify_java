package com.project.lookify.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Transient;
import javax.persistence.Column;
import javax.validation.constraints.Size;
import javax.validation.constraints.Min;
import javax.validation.constraints.Max;

import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.Email;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Song{
	@Id
	@GeneratedValue
	private long id;

	@Column
	@Size(min = 1, max = 100)
	private String title;

	@Column
	@Size(min = 1, max = 100)
	private String artist;

	@Column
	@Min(1)
	@Max(5)
	private int rating;
	 
	
	@DateTimeFormat(pattern="MM:dd:yyyy HH:mm:ss")
	private Date createdAt;
	
	@DateTimeFormat(pattern="MM:dd:yyyy HH:mm:ss")
	private Date updatedAt;

	@PrePersist
	public void onCreate(){this.createdAt = new Date();}
	@PreUpdate
	public void onUpdate(){this.updatedAt = new Date();}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	public String getTitle() {
	    return title;
	}
	 
	public void setTitle(String title) {
	    this.title = title;
	}
	 
	public String getArtist() {
	    return artist;
	}
	 
	public void setArtist(String artist) {
	    this.artist = artist;
	}

	public int getRating() {
	    return rating;
	}
	 
	public void setRating(int rating) {
	    this.rating = rating;
	}
	
	public Song(){
		this.createdAt = new Date();
		this.updatedAt = new Date();
	}
}
