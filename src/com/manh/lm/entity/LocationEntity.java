package com.manh.lm.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="location")
public class LocationEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7189335649464051387L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	
	private Integer id;
	
	private Double latitude;
	private Double longitude;
	private Double altitude;
	private Double speed;
	private String vehicle;
	
	public LocationEntity() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public LocationEntity(Integer id, Double latitude, Double longitude,
			Double altitude, Double speed, String vehicle) {
		super();
		this.id = id;
		this.latitude = latitude;
		this.longitude = longitude;
		this.altitude = altitude;
		this.speed = speed;
		this.vehicle = vehicle;
	}
	
	



	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public Double getSpeed() {
		return speed;
	}
	public void setSpeed(Double speed) {
		this.speed = speed;
	}
	public String getVehicle() {
		return vehicle;
	}
	public void setVehicle(String vehicle) {
		this.vehicle = vehicle;
	}
	
	
}
