package org.peerhealthexchange.phemobile.objects;

public class Website {
	private String objectId;
	private String cityId;
	private String hotlineTitleId;
	private String name;
	private String website;
	
	public Website() {
	}
	
	public Website(String objectId, String cityId, String hotlineTitleId, String name, String website){
		this.objectId = objectId;
		this.cityId = cityId;
		this.hotlineTitleId = hotlineTitleId;
		this.name = name;
		this.website = website;
	}
	
	
	// set values
	public void setId(String id) {
		this.objectId = id;
	}

	public void setCityId(String id) {
		this.cityId = id;
	}
	
	public void setHotlineTitleId(String id) {
		this.hotlineTitleId = id;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public void setWebsite(String website){
		this.website = website;
	}
	
	//get values
	
	public String getName(){
		return this.name;
	}
	
	public String getWebsite(){
		return this.website;
	}
}
