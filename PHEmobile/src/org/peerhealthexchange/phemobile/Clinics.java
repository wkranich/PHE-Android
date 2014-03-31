package org.peerhealthexchange.phemobile;

public class Clinics {
	// there will be no setters as any updates will simply drop the tables and recreate everything
	private String objectId;
	private String cityId;
	private String name;
	private String address;
	private String hours;
	private String phone;
	private String details;
	private Boolean confidential,lowCost,reproductive;
	private String geoPoint;
	
	// empty constructor
	public Clinics(){};
	
	// this is the constructor to use
	public Clinics(String objectId, String cityId, String Name, 
			String Address, String Hours, String Phone, String Details, 
			Boolean Confidential, Boolean LowCost, Boolean Reproductive, String geoPoint){
		this.objectId = objectId;
		this.cityId = cityId;
		this.name = Name;
		this.address = Address;
		this.hours = Hours;
		this.phone = Phone;
		this.details = Details;
		this.confidential = Confidential;
		this.lowCost = LowCost;
		this.reproductive = Reproductive;
		this.geoPoint = geoPoint;
	}
	
	
	public void setId(String id) {
        this.objectId = id;
    }
	
	public void setCityId(String id) {
        this.cityId = id;
    }
	
	public void setName(String name){
		this.name = name;
	}
	
	public void setAddress(String address){
		this.address = address;
	}
	
	public void setHours(String hours){
		this.hours = hours;
	}
	
	public void setPhone(String phone){
		this.phone = phone;
	}
	
	public void setDetails(String details){
		this.details = details;
	}
	
	public void setConfidential(Boolean confidential){
		this.confidential = confidential;
	}
	
	public void setLowCost(Boolean lowCost){
		this.lowCost = lowCost;
	}
	
	public void setReproductive(Boolean reproductive){
		this.reproductive = reproductive;
	}
	
	public void setGeoPoint(String geoPoint){
		this.geoPoint = geoPoint;
	}
	
	// your getters
	public String getId() {
		return this.objectId;
	}
	
	public String getCityId() {
		return this.cityId;
	}
	
	public String getName(){
		return this.name;
	}
	
	public String getAddress(){
		return this.address;
	}
	
	public String getHours(){
		return this.hours;
	}
	
	public String getPhone(){
		return this.phone;
	}
	
	public String getDetails(){
		return this.details;
	}
	
	public Boolean getConfidential() {
		return this.confidential;
	}
	
	public Boolean getLowCost(){
		return this.lowCost;
	}
	
	public Boolean getReproductive() {
		return this.reproductive;
	}
	
	public String getGeoPoint(){
		return this.geoPoint;
	}
}
