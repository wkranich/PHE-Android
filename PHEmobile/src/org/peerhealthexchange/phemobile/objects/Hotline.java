package org.peerhealthexchange.phemobile.objects;

public class Hotline {
	private String objectId;
	private String cityId;
	private String hotlineTitleId;
	private String name;
	private String phoneNumber;
	private String extraDetails;

	// empty constructor
	public Hotline() {
	};

	// this is the constructor to use
	public Hotline(String objectId, String cityId, String hotlineTitleId, 
			String Name, String phoneNumber, String extraDetails) {
		this.objectId = objectId;
		this.cityId = cityId;
		this.hotlineTitleId = hotlineTitleId;
		this.name = Name;
		this.phoneNumber = phoneNumber;
		this.extraDetails = extraDetails;
	}

	public void setId(String id) {
		this.objectId = id;
	}

	public void setCityId(String id) {
		this.cityId = id;
	}
	
	public void setHotlineTitleId(String id) {
		this.hotlineTitleId = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public void setExtraDetails(String extraDetails) {
		this.extraDetails = extraDetails;
	}

	// your getters
	public String getId(){
		return this.objectId;
	}
	
	public String getCityId(){
		return this.cityId;
	}
	
	public String getHotlineId(){
		return this.hotlineTitleId;
	}
	
	public String getName() {
		return this.name;
	}

	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public String getExtraDetails() {
		return this.extraDetails;
	}

}
