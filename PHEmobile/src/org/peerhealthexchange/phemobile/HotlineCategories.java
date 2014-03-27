package org.peerhealthexchange.phemobile;

public class HotlineCategories {
	private String objectId;
    private String hotlineTitle;
 
    // constructors
    public HotlineCategories() {
    }
 
    public HotlineCategories(String id, String hotlineTitle) {
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
