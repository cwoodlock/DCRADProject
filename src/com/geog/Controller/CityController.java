package com.geog.Controller;

import java.util.*;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import com.mysql.jdbc.CommunicationsException;
import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;

import com.geog.DAO.DAO;//Import the DAO
import com.geog.Model.City;//Import the model for country

@ManagedBean
public class CityController {
	
	ArrayList<City> cities;
	private DAO dao; //DAO connection
	
	public CityController() {
		super();
		cities = new ArrayList<City>();
		try {
			dao = new DAO();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public CityController(ArrayList<City> cities) {
		super();
		this.cities = cities;
	}
	
	public ArrayList<City> getCities() {
		return cities;
	}
	
	public void setCities(ArrayList<City> countries) {
		this.cities = countries;
	}
	
	public void loadCities() throws Exception {
		cities.clear();
		if (dao != null) {
			try {
				cities = dao.loadCity();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public String addCountry(City city) {
		if (dao != null) {
			try {
				dao.addCity(city);
				return "index";
			} catch (MySQLIntegrityConstraintViolationException e) {
				FacesMessage message = new FacesMessage("Error: City code " + city.getCode() + " already exists");
				FacesContext.getCurrentInstance().addMessage(null, message);
				return null;
			} catch (CommunicationsException e) {
				FacesMessage message = new FacesMessage("Error: Cannot connect to Database");
				FacesContext.getCurrentInstance().addMessage(null, message);
				return null;
			} catch (Exception e) {
				FacesMessage message = new FacesMessage("Error while trying to insert City " + city.getCode());
				FacesContext.getCurrentInstance().addMessage(null, message);
				return null;
			}
		}
		return null;
	}
	
	
	
}
