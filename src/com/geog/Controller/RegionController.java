//Colm Woodlock G00341460
package com.geog.Controller;

import java.util.*;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import com.mysql.jdbc.CommunicationsException;
import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;

import com.geog.DAO.DAO;//Import the DAO
import com.geog.Model.Region;//Import the model for country

@ManagedBean
public class RegionController {
	
	ArrayList<Region> regions;
	private DAO dao; //DAO connection
	
	public RegionController() {
		super();
		regions = new ArrayList<Region>();
		try {
			dao = new DAO();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public RegionController(ArrayList<Region> regions) {
		super();
		this.regions = regions;
	}
	
	public ArrayList<Region> getRegions() {
		return regions;
	}
	
	public void setRegions(ArrayList<Region> regions) {
		this.regions = regions;
	}
	
	public void loadRegions() throws Exception {
		regions.clear();
		if (dao != null) {
			try {
				regions = dao.loadRegion();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public String addRegion(Region region) {
		if (dao != null) {
			try {
				dao.addRegion(region);
				return "index";
			} catch (MySQLIntegrityConstraintViolationException e) {
				FacesMessage message = new FacesMessage("Error: Region code " + region.getCode() + " already exists");
				FacesContext.getCurrentInstance().addMessage(null, message);
				return null;
			} catch (CommunicationsException e) {
				FacesMessage message = new FacesMessage("Error: Cannot connect to Database");
				FacesContext.getCurrentInstance().addMessage(null, message);
				return null;
			} catch (Exception e) {
				FacesMessage message = new FacesMessage("Error while trying to insert Region " + region.getCode());
				FacesContext.getCurrentInstance().addMessage(null, message);
				return null;
			}
		}
		return null;
	}
	
	
	
}

