package com.iyihua.itimes.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Location implements Serializable {

	private static final long serialVersionUID = 7525327812218240003L;
	
	@Id
	@GeneratedValue
	private Long locationd;
	@Column(nullable = false)
	private String location;
	@Column(nullable = false)
	private Long userId;
	
	public Location() {
		super();
	}
	public Location(Long locationd, String location, Long userId) {
		super();
		this.locationd = locationd;
		this.location = location;
		this.userId = userId;
	}
	@Override
	public String toString() {
		return "Location [locationd=" + locationd + ", location=" + location + ", userId=" + userId + "]";
	}
	public Long getLocationd() {
		return locationd;
	}
	public void setLocationd(Long locationd) {
		this.locationd = locationd;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
	
}
