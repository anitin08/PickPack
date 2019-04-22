package com.example.demo.RequestTable;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
 
@Entity
@Table(name = "Request")
public class RequestTable {
	@Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long Id;
 
	@NotNull
    @Column(name = "Name")
    String name;
 
    @NotNull
    @Column(name = "Track_Id", unique=true)
    String trackid;
	
    public String getTrackid() {
		return trackid;
	}

	public void setTrackid(String track_id) {
		this.trackid = track_id;
	}

	public long getId() {
		return Id;
	}
	
	public void setId(long id) {
		Id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

 
}
