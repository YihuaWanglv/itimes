package com.iyihua.model.base;

import java.io.Serializable;

public class LocationDTO implements Serializable {

	private static final long serialVersionUID = 7525327812218241003L;
	
	private Long locationId;
	private String location;
	private Long userId;
	
	public LocationDTO() {
		super();
	}
	public LocationDTO(Long locationId, String location, Long userId) {
		super();
		this.locationId = locationId;
		this.location = location;
		this.userId = userId;
	}
	@Override
	public String toString() {
		return "Location [locationd=" + locationId + ", location=" + location + ", userId=" + userId + "]";
	}
	public Long getLocationId() {
		return locationId;
	}
	public void setLocationId(Long locationId) {
		this.locationId = locationId;
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
