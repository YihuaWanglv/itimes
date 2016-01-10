package com.iyihua.model.base;

import java.io.Serializable;

public class LocationDTO implements Serializable {

	private static final long serialVersionUID = 7525327812218241003L;
	
	private Long locationd;
	private String location;
	private Long userId;
	
	public LocationDTO() {
		super();
	}
	public LocationDTO(Long locationd, String location, Long userId) {
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
