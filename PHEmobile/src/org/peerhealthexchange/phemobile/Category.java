package org.peerhealthexchange.phemobile;

public class Category {
	private String objectId;
    private String hotlineTitle;
 
    // constructors
    public Category() {
    }
 
    public Category(String id, String hotlineTitle) {
        this.objectId= id;
        this.hotlineTitle = hotlineTitle;
    }
 
    // setters
    public void setId(String id) {
        this.objectId = id;
    }
 
    public void setName(String hotlineTitle) {
        this.hotlineTitle = hotlineTitle;
    }
 
    // getters
    public String getId() {
        return this.objectId;
    }
 
    public String getHotlineTitle() {
        return this.hotlineTitle;
    }

}
