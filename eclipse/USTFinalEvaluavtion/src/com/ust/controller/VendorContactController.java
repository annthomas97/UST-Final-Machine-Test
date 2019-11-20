package com.ust.controller;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ust.dao.IVendorContactDao;
import com.ust.model.ContactVendor;
import com.ust.model.Login;

@RestController
public class VendorContactController {

	@Autowired
	IVendorContactDao dao;

	/*---------------------------------------- LOGIN----------------------------------------------------*/

	@RequestMapping(value = "/api/login/{username}/{password}", method = RequestMethod.GET)
	public Login getLoginUser(@PathVariable("username") String username,
			@PathVariable("password") String password) {
		return dao.loginUser(username, password);
	}

	/*-------------------------------------- INSERT/UPDATE VENDOR------------------------------------------------*/

	@RequestMapping(value = "/api/saveVendor", method = { RequestMethod.POST,
			RequestMethod.PUT })
	public void vendorInsert(@RequestBody ContactVendor vb) {
		System.out.println(vb.getVendorId());
		if (vb.getVendorId() != 0) {
			dao.updateVendor(vb);
		} else {
			dao.insertVendor(vb);
		}
	}

	/*------------------------------------- DISPLAY ALL VENDORS-----------------------------------------------*/

	@RequestMapping(value = "/api/vendors", method = RequestMethod.GET)
	public List<ContactVendor>getVendorDetails() {
		List list = dao.getVendorDetails();
		return list;
	}

	/*--------------------------------- DISPLAY VENDOR DETAILS BY ID--------------------------------------------*/

	@RequestMapping(value = "/api/vendorbyid/{vendorId}", method = RequestMethod.GET)
	
	public ContactVendor getVendorById(@PathVariable("vendorId") int vendorId) {
	ContactVendor venderContact = dao.getVendorById(vendorId);
	return venderContact;
	}

	/*--------------------------------------- SEARCH VENDOR-------------------------------------------------------*/

	@RequestMapping(value = "/api/searchVendor/{searchString}", method = RequestMethod.GET)
	public List<ContactVendor> getVendor(
			@PathVariable("searchString") String searchString) {
		List list = dao.getVendor(searchString);
		return list;
	}

	/*--------------------------------------- DISABLE VENDOR BY ID-------------------------------------------------*/

	@RequestMapping(value = "/api/disableVendorById/{vendorId}", method = RequestMethod.PUT)
	void vendorDisable(@PathVariable("vendorId") int vendorId) {
		dao.disableVendor(vendorId);
	}

}
