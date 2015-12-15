package com.manh.lm.domain;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement(name="coordinates")
public class Coordinates implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3680199523969051700L;
	private Integer id;
	private Double lat1;
	private Double lng1;
	private Double lat2;
	private Double lng2;
	private String name;
	
	public Coordinates()
	{
		
	}


	
	public Coordinates(Integer id, Double lat1, Double lng1, Double lat2,
			Double lng2, String name) {
		super();
		this.id = id;
		this.lat1 = lat1;
		this.lng1 = lng1;
		this.lat2 = lat2;
		this.lng2 = lng2;
		this.name = name;
	}

	public Double getLat1() {
		return lat1;
	}

	public void setLat1(Double lat1) {
		this.lat1 = lat1;
	}

	public Double getLng1() {
		return lng1;
	}

	public void setLng1(Double lng1) {
		this.lng1 = lng1;
	}

	public Double getLat2() {
		return lat2;
	}

	public void setLat2(Double lat2) {
		this.lat2 = lat2;
	}

	public Double getLng2() {
		return lng2;
	}

	public void setLng2(Double lng2) {
		this.lng2 = lng2;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	

}
