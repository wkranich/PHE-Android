package org.peerhealthexchange.phemobile;

public class Cities {
	private String objectId;
    private String name;
 
    // constructors
    public Cities() {
    }
 
    public Cities(String id, String name) {
        this.objectId= id;
        this.name = name;
    }
 
    // setters
    public void setId(String id) {
        this.objectId = id;
    }
 
    public void setName(String name) {
        this.name = name;
    }
 
    // getters
    public String getId() {
        return this.objectId;
    }
 
    public String getName() {
        return this.name;
    }

}
