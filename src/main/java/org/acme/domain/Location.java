package org.acme.domain;



public class Location {

    public String location;
    public int id;
    public int intervals;

    public Location() {

    }
    public Location(int id,String locationname) {
        this.id = id;
        this.location = locationname;
    }
    public String getLocationname() {
        return location;
    }
    public int getId() {
        return id;
    }
    public void setlocationname(String locationname) {
        this.location = locationname;
    }
    public void setId(int ID) {
        this.id = ID;
    }
    @Override
    public String toString() {
        return location + " " + id;
    }
}