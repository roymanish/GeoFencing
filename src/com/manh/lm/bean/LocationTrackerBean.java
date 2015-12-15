package com.manh.lm.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UISelectItems;
import javax.faces.component.html.HtmlSelectOneMenu;
import javax.faces.model.SelectItem;

import com.manh.lm.dao.CoordinatelistService;
import com.manh.lm.dao.LocationlistService;
import com.manh.lm.domain.Coordinates;
import com.manh.lm.domain.Location;
import com.manh.lm.rest.CoordinatesRestService;


@ManagedBean(name="trackerBean")
@ViewScoped
public class LocationTrackerBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String entityName;
	private List<Location> locations;
	private String delimitedLocData = "";
	private Coordinates coordinates = new Coordinates(1,null,null,null,null,"");
	private String coords;
	private String facilityName;
	private HtmlSelectOneMenu locationSelectOneMenu;
	
	
	/**
	 * @return the locationSelectOneMenu
	 */
	public HtmlSelectOneMenu getLocationSelectOneMenu() {
		
		final Collection list = new ArrayList();
		if(this.locationSelectOneMenu == null)
			this.locationSelectOneMenu = new HtmlSelectOneMenu();
		
		if(this.locations != null && !this.locations.isEmpty()){
			
			for(Location l : this.locations){
				
				list.add(new SelectItem(l.getVehicle(),l.getVehicle()));
			}
		}
		final UISelectItems items = new UISelectItems();
		items.setValue(list);
		this.locationSelectOneMenu.getChildren().add(items);
		return locationSelectOneMenu;
	}
	/**
	 * @param locationSelectOneMenu the locationSelectOneMenu to set
	 */
	public void setLocationSelectOneMenu(HtmlSelectOneMenu locationSelectOneMenu) {
		this.locationSelectOneMenu = locationSelectOneMenu;
	}
	/**
	 * @return the facilityName
	 */
	public String getFacilityName() {
		return facilityName;
	}
	/**
	 * @param facilityName the facilityName to set
	 */
	public void setFacilityName(String facilityName) {
		this.facilityName = facilityName;
	}
	/**
	 * @return the coords
	 */
	public String getCoords() {
		return coords;
	}
	/**
	 * @param coords the coords to set
	 */
	public void setCoords(String coords) {
		this.coords = coords;
	}
	/**
	 * @return the coordinates
	 */
	public Coordinates getCoordinates() {
		return coordinates;
	}
	/**
	 * @param coordinates the coordinates to set
	 */
	public void setCoordinates(Coordinates coordinates) {
		this.coordinates = coordinates;
	}
	/**
	 * @return the delimitedLocData
	 */
	public String getDelimitedLocData() {
		return delimitedLocData;
	}
	/**
	 * @param delimitedLocData the delimitedLocData to set
	 */
	public void setDelimitedLocData(String delimitedLocData) {
		this.delimitedLocData = delimitedLocData;
	}
	/**
	 * 
	 */
	public LocationTrackerBean() {
		super();

		try {
			this.locations =new LocationlistService().getLocationList();
			this.delimitedLocData = this.createDelimitedLocData();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	/**
	 * @return the entityName
	 */
	public String getEntityName() {
		return entityName;
	}
	/**
	 * @param entityName the entityName to set
	 */
	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}
	/**
	 * @return the locations
	 */
	public List<Location> getLocations() {
		return locations;
	}
	/**
	 * @param locations the locations to set
	 */
	public void setLocations(List<Location> locations) {
		this.locations = locations;
	}
	
	private String createDelimitedLocData(){
		
		for(Location loc : this.locations){
			
			String locData = loc.getVehicle()+"/"+loc.getLatitude()+"/"+loc.getLongitude()+"/"+loc.getVehicle()+"?";
			this.delimitedLocData = this.delimitedLocData+locData;
		}
		this.delimitedLocData = !this.delimitedLocData.isEmpty() ? this.delimitedLocData.substring(0, this.delimitedLocData.length()-1) : this.delimitedLocData;
		return this.delimitedLocData;
	}
	
	public void saveCoordinateData(Coordinates c){		
		try {
			new CoordinatelistService().saveCoordinates(c);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public String saveLocation(){
		
		String coords = this.coords.substring(1, this.coords.length()-1);
		String[] coords1 = coords.split(",");
		String[] lat1 = coords1[0].split(":");
		String[] lng1 = coords1[1].split(":");
		String[] lat2 = coords1[2].split(":");
		String[] lng2 = coords1[3].split(":");
		this.coordinates = new Coordinates(null,new Double(lat1[1]),new Double(lng1[1]),new Double(lat2[1]),new Double(lng2[1]),this.facilityName );
		return "";
	}
	
}
