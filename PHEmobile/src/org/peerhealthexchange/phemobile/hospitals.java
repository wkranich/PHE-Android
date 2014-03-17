package org.peerhealthexchange.phemobile;

public class hospitals {
	// there will be no setters as any updates will simply drop the tables and recreate everything
	private String Name;
	private String Address;
	private String Hours;
	private int Phone;
	
	// empty constructor
	public hospitals(){};
	
	// this is the constructor to use
	public hospitals(String Name, String Address, String Hours, int Phone){
		this.Name = Name;
		this.Address = Address;
		this.Hours = Hours;
		this.Phone = Phone;
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
	
	public int getPhone(){
		return this.Phone;
	}
}
