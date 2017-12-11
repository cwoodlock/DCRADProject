//Colm Woodlock G00341460
package com.geog.Controller;

import java.util.*;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;


import com.geog.DAO.DAO;//Import the DAO
import com.geog.DAO.MongoDAO;//Import the MongoDAO
import com.geog.Model.Country;
import com.geog.Model.HeadOfState;
import com.mysql.jdbc.CommunicationsException;
import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;

public class HeadOfStateController {
	
	ArrayList<HeadOfState> hofs;
	private DAO dao; //DAO connection
	private MongoDAO mongodao; //MongoDAO connection
	
	public HeadOfStateController(){
		super();
		hofs = new ArrayList<HeadOfState>();
		try {
			mongodao = new MongoDAO();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public HeadOfStateController(ArrayList<HeadOfState> hofs) {
		super();
		this.hofs = hofs;
	}
	
	public ArrayList<HeadOfState> getHofs() {
		return hofs;
	}
	
	public void setHofs(ArrayList<HeadOfState> hofs) {
		this.hofs = hofs;
	}
	
	public void loadHofs() throws Exception {
		hofs.clear();
		if (mongodao != null) {
			try {
				hofs = mongodao.loadHofs();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public String addHof(HeadOfState hof) {
		if (mongodao != null) {
			try {
				mongodao.addHof(hof);
				return "index";
			} catch (MySQLIntegrityConstraintViolationException e) {
				FacesMessage message = new FacesMessage("Error: Head of State _id " + hof.get_id() + " already exists");
				FacesContext.getCurrentInstance().addMessage(null, message);
				return null;
			} catch (CommunicationsException e) {
				FacesMessage message = new FacesMessage("Error: Cannot connect to Database");
				FacesContext.getCurrentInstance().addMessage(null, message);
				return null;
			} catch (Exception e) {
				FacesMessage message = new FacesMessage("Error while trying to insert Country " + hof.get_id());
				FacesContext.getCurrentInstance().addMessage(null, message);
				return null;
			}
		}
		return null;
	}
	
}
