package com.manh.lm.domain;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement(name="location")
public class Location implements Serializable  {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8232196670939050656L;
	private Integer id;
	private Double latitude;
	private Double longitude;
	private Double altitude;
	private Double speed;
	private String vehicle;
	public Location(){
		
	}
	public Location(Integer id,Double latitude, Double longitude, Double altitude,	Double speed,		
			 String vehicle) {
		super();
		this.id=id;
		this.latitude = latitude;
		this.longitude = longitude;
		this.altitude = altitude;
		this.speed = speed;
		this.vehicle = vehicle;
	}
	
	public Location( Double latitude, Double longitude,
			Double altitude, Double speed, String vehicle) {
		super();
		
		this.latitude = latitude;
		this.longitude = longitude;
		this.altitude = altitude;
		this.speed = speed;
		this.vehicle = vehicle;
	}
	
	
	
	public Double getSpeed() {
		return speed;
	}
	public void setSpeed(Double speed) {
		this.speed = speed;
	}
	public Double getLatitude() {
		return latitude;
	}
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}
	public Double getLongitude() {
		return longitude;
	}
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
	public Double getAltitude() {
		return altitude;
	}
	public void setAltitude(Double altitude) {
		this.altitude = altitude;
	}	
	
	public String getVehicle() {
		return vehicle;
	}
	public void setVehicle(String vehicle) {
		this.vehicle = vehicle;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	

}
