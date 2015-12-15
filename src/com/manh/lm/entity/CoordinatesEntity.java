package com.manh.lm.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name="coord")
public class CoordinatesEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3721798269447772227L;
	/**
	 * 
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private Double lat1;
	private Double lng1;
	
	
	private Double lat2;
	private Double lng2;
	private String name;
	
	public CoordinatesEntity()
	{
		
	}

	public CoordinatesEntity(Integer id,Double lat1, Double lng1, Double lat2, Double lng2,
			String name) {
		super();
		this.id=id;
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
