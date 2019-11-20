package com.ust.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.ust.model.ContactVendor;
import com.ust.model.Login;

/*--------------------------------------JDBC TEMPLATE-----------------------------------------------------------------------------------------*/
public class VendorContactDao implements IVendorContactDao {
	JdbcTemplate template;
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	/*---------------------------------------LOGIN------------------------------------------------------------------------*/
	
	
	@Override
	public Login loginUser(String username, String password) {
		String sql = "select userId from loginTable"
				+ " where username=?"
				+" and password=?" ;
		return template.queryForObject(sql, new Object[] {username,password},
				new BeanPropertyRowMapper<Login>(Login.class));
	}
	
	

	/*-----------------------------GET ALL VENDORS--------------------------------------------------------------------------*/
	
	
	@Override
	public List<ContactVendor> getVendorDetails() {
		return template
		.query("select vt.vendorId,vt.vendorName,address,location,service,pincode,isActiveV,contactId,contactName,"
				+ "department,email,phone from vendorTable vt join personTable ct"
				+ " on(vt.vendorId=ct.vendorId) where isActiveV='yes' order by vendorId,contactId ",
						new RowMapper<ContactVendor>() {
							public ContactVendor mapRow(ResultSet rs, int row)
									throws SQLException {
								ContactVendor vc = new ContactVendor();
								vc.setVendorId(rs.getInt(1));
								vc.setVendorName(rs.getString(2));
								vc.setAddress(rs.getString(3));
								vc.setLocation(rs.getString(4));
								vc.setService(rs.getString(5));
								vc.setPincode(rs.getInt(6));
								vc.setIsActiveV(rs.getString(7));
								vc.setContactId(rs.getInt(8));
								vc.setContactName(rs.getString(9));
								vc.setDepartment(rs.getString(10));
								vc.setEmail(rs.getString(11));
								vc.setPhone(rs.getString(12));
								return vc;
							}
						});
	}
	
	/*----------------------------VENDOR BY ID----------------------------------------------------------------------------*/
	
	@Override
	public ContactVendor getVendorById(int vendorId){
		String sql="select vt.vendorId,vendorName,address,location,service,pincode,isActiveV,contactId,contactName,"
				+ "department,email,phone from vendorTable vt join personTable ct"
				+ " on(vt.vendorId=ct.vendorId) where vt.vendorId=?";
		return template.queryForObject(sql, new Object[] { vendorId },
				new BeanPropertyRowMapper<ContactVendor>(ContactVendor.class));
	}

	/*--------------------------------------DISABLE VENDOR----------------------------------------------------------------------*/
	
	@Override
	public int disableVendor(int vendorId) {
		
		String sql = "update vendorTable set isActiveV='no' where vendorId=?";
		return template.update(sql,new Object[] { vendorId });
	}
/*------------------------------------------------INSERT/UPDATE VENDOR------------------------------------------------------------------*/
	
	@Override
	public int insertVendor(ContactVendor vendorContact) {
		String sql="insert into vendorTable(vendorName,address,location,service,pincode,isActiveV) "
				+ "values ('"+vendorContact.getVendorName()+"','"+vendorContact.getAddress()+"','"
				+vendorContact.getLocation()+"','"+vendorContact.getService()+"',"
				+vendorContact.getPincode()+",'yes"+"')";
		template.update(sql);
		
		
		String sql1="select max(vendorId) from vendorTable";
		int vendorId=template.queryForObject(sql1, Integer.class);
		
		String sql2="insert into personTable(contactName,vendorId,department,email,phone,isActiveP) "
				+ "values (?,?,?,?,?,'yes')";
		return template.update(sql2,new Object[] {vendorContact.getContactName(),vendorId,vendorContact.getDepartment(),
				vendorContact.getEmail(),vendorContact.getPhone()});
		
	}
	
	@Override
	public int updateVendor(ContactVendor vendorContact) 
	{
		String sql = "update vendorTable set vendorName = '"+vendorContact.getVendorName()+
				"',address='"+vendorContact.getAddress()+"', location='"+vendorContact.getLocation()
				+ "', service='"+vendorContact.getService()+"',pincode= "+vendorContact.getPincode()
				+ "where vendorId = "+vendorContact.getVendorId()+"";
			template.update(sql, new Object[] {});
		
		String sql1 = "update personTable set contactName = '"+vendorContact.getContactName()+"'"
					+ ",department='"+vendorContact.getDepartment()
					+ "', email='"+vendorContact.getEmail()+"',phone='"+vendorContact.getPhone()
					+"' where contactId = "+vendorContact.getVendorId()+"";
			return template.update(sql1, new Object[] {});
		
	}
	/*----------------------------------------------- SEARCH VENDOR--------------------------------------------------------------------*/
	
	@Override
	public List<ContactVendor> getVendor(String searchString)
	{
		return template.query("select vendorId,vendorName,address,location,service,pincode,contactId,contactName,department"
		+ ",email,phone from vendorTable join personTable using(vendorId)"
		+ "where location Like '"+searchString+"%' or vendorName Like '"+searchString+"%'"
		+"or contactName Like '"+searchString+"%'or service Like '"+searchString+"%'",
		new RowMapper<ContactVendor>()
	{
	public ContactVendor mapRow(ResultSet rs, int row)throws SQLException
	{
		ContactVendor cv = new ContactVendor();
		 cv.setVendorId(rs.getInt(1));
		 cv.setVendorName(rs.getString(2));;
		 cv.setAddress(rs.getString(3));
		 cv.setLocation(rs.getString(4));
		 cv.setService(rs.getString(5));
		 cv.setPincode(rs.getInt(6));
		 cv.setContactId(rs.getInt(7));
		 cv.setContactName(rs.getString(8));
		 cv.setDepartment(rs.getString(9));
		 cv.setEmail(rs.getString(10));
		 cv.setPhone(rs.getString(11));
		return  cv ;
		}
	});
	}





}

