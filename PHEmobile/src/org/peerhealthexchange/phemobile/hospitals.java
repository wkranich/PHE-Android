package org.peerhealthexchange.phemobile;

public class hospitals {
	// there will be no setters as any updates will simply drop the tables and recreate everything
	private String objectId;
	private String cityId;
	private String name;
	private String address;
	private String hours;
	private String phone;
	private String details;
	private Boolean confidential,lowCost,reproductive;
	
	// empty constructor
	public hospitals(){};
	
	// this is the constructor to use
	public hospitals(String objectId, String cityId, String Name, 
			String Address, String Hours, String Phone, String Details, 
			Boolean Confidential, Boolean LowCost, Boolean Reproductive){
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
	
	
	// your getters
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
}
