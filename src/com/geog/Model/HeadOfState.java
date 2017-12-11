//Colm Woodlock G00341460
package com.geog.Model;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class HeadOfState {
	private String _id;
	private String headOfState;
	
	//Contructors
	public HeadOfState(){
		super();
	}
		
	public HeadOfState(String _id, String HeadOfState){
		super();
		this._id = _id;
		this.headOfState = headOfState;
		
	}

	//Getters and Setters
	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public String getHeadOfState() {
		return headOfState;
	}

	public void setHeadOfState(String headOfState) {
		this.headOfState = headOfState;
	}
	
}

