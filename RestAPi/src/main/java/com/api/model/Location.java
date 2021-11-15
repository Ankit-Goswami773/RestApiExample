package com.api.model;

public class Location {
	
	public int id;
    public String address;
    public String city;
    public String zipCode;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public Location(int id, String address, String city, String zipCode) {
		super();
		this.id = id;
		this.address = address;
		this.city = city;
		this.zipCode = zipCode;
	}
	public Location() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Location [id=" + id + ", address=" + address + ", city=" + city + ", zipCode=" + zipCode + "]";
	}
    
    

}
