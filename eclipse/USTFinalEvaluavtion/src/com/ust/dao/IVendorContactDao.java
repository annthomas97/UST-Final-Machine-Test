package com.ust.dao;

import java.util.List;

import com.ust.model.ContactVendor;
import com.ust.model.Login;

public interface IVendorContactDao {

	//login
	public abstract Login loginUser(String username, String password);

	public abstract List<ContactVendor> getVendorDetails();

	/*----------------------------VENDOR BY ID----------------------------------------------------------------------------*/
	public abstract ContactVendor getVendorById(int vendorId);

	/*--------------------------------------DISABLE VENDOR----------------------------------------------------------------------*/
	public abstract int disableVendor(int vendorId);

	/*------------------------------------------------INSERT/UPDATE VENDOR------------------------------------------------------------------*/
	public abstract int insertVendor(ContactVendor vendorContact);

	public abstract int updateVendor(ContactVendor vendorContact);

	/*----------------------------------------------- SEARCH VENDOR--------------------------------------------------------------------*/
	public abstract List<ContactVendor> getVendor(String searchString);

}