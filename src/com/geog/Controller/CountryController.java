package com.geog.Controller;

import java.util.*;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import com.mysql.jdbc.CommunicationsException;
import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;

import com.geog.DAO.DAO;//Import the DAO
import com.geog.Model.Country;//Import the model for country

@ManagedBean
public class CountryController {
	
	ArrayList<Country> countries;
	private DAO dao; //DAO connection
	
	public CountryController() {
		super();
		countries = new ArrayList<Country>();
		try {
			dao = new DAO();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public CountryController(ArrayList<Country> countries) {
		super();
		this.countries = countries;
	}
	
	public ArrayList<Country> getCountries() {
		return countries;
	}
	
	public void setCountries(ArrayList<Country> countries) {
		this.countries = countries;
	}
	
	public void loadCountries() throws Exception {
		countries.clear();
		if (dao != null) {
			try {
				countries = dao.loadCountries();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	
	
}
