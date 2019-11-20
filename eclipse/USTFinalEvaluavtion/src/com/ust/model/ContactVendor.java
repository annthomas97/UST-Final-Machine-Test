package com.ust.model;

public class ContactVendor {
	// instance variable

	private int contactId;
	private String contactName;
	private int vendorId;
	private String department;
	private String email;
	private String phone;
	private String isActiveP;

	// private int vendorId;
	private String vendorName;
	private String address;
	private String location;
	private String service;
	private int pincode;
	private String isActiveV;

	// default constructor
	public ContactVendor() {
		super();
	}

	// Parameterized constructor

	public ContactVendor(int contactId, String contactName, int vendorId,
			String department,String email, String phone, String isActiveP,
			String vendorName, String address, String location, String service,
			int pincode, String isActiveV) {
		super();
		this.contactId = contactId;
		this.contactName = contactName;
		this.vendorId = vendorId;
		this.department = department;
		this.email=email;
		this.phone = phone;
		this.isActiveP = isActiveP;
		this.vendorName = vendorName;
		this.address = address;
		this.location = location;
		this.service = service;
		this.pincode = pincode;
		this.isActiveV = isActiveV;
	}

	// getters and setters

	public int getContactId() {
		return contactId;
	}

	public void setContactId(int contactId) {
		this.contactId = contactId;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public int getVendorId() {
		return vendorId;
	}

	public void setVendorId(int vendorId) {
		this.vendorId = vendorId;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getIsActiveP() {
		return isActiveP;
	}

	public void setIsActiveP(String isActiveP) {
		this.isActiveP = isActiveP;
	}

	public String getVendorName() {
		return vendorName;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	public String getIsActiveV() {
		return isActiveV;
	}

	public void setIsActiveV(String isActiveV) {
		this.isActiveV = isActiveV;
	}

	// toString method
	
	@Override
	public String toString() {
		return "ContactVendor [contactId=" + contactId + ", contactName="
				+ contactName + ", vendorId=" + vendorId + ", department="
				+ department + ", email=" + email + ", phone=" + phone
				+ ", isActiveP=" + isActiveP + ", vendorName=" + vendorName
				+ ", address=" + address + ", location=" + location
				+ ", service=" + service + ", pincode=" + pincode
				+ ", isActiveV=" + isActiveV + "]";
	}

	
	

}
