package org.peerhealthexchange.phemobile;

public class hospitals {
	// there will be no setters as any updates will simply drop the tables and recreate everything
	private String Name;
	private String Address;
	private String Hours;
	private String Phone;
	private String Details;
	private Boolean Confidential,LowCost,Reproductive;
	
	// empty constructor
	public hospitals(){};
	
	// this is the constructor to use
	public hospitals(String Name, String Address, String Hours, String Phone, String Details, Boolean Confidential, Boolean LowCost, Boolean Reproductive){
		this.Name = Name;
		this.Address = Address;
		this.Hours = Hours;
		this.Phone = Phone;
		this.Details = Details;
		this.Confidential = Confidential;
		this.LowCost = LowCost;
		this.Reproductive = Reproductive;
	}
	
	// your getters
	public String getName(){
		return this.Name;
	}
	
	public String getAddress(){
		return this.Address;
	}
	
	public String getHours(){
		return this.Hours;
	}
	
	public String getPhone(){
		return this.Phone;
	}
	
	public String getDetails(){
		return this.Details;
	}
}
