//Colm Woodlock G00341460
package com.geog.Model;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class City {
	private String code;
	private String countryCode;
	private String regCode;
	private String name;
	private long population;
	private boolean bts;
	private double area;
	
	//Constructors
	public City(){
		super();
	}
	
	public City(String code, String countryCode, String regCode, String name, long population, boolean bts, double area){
		super();
		this.code = code;
		this.countryCode = countryCode;
		this.regCode = regCode;
		this.name = name;
		this.population = population;
		this.bts = bts;
		this.area = area;
	}

	//Getters and Setters
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getRegCode() {
		return regCode;
	}

	public void setRegCode(String regCode) {
		this.regCode = regCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getPopulation() {
		return population;
	}

	public void setPopulation(long population) {
		this.population = population;
	}

	public boolean isBts() {
		return bts;
	}

	public void setBts(boolean bts) {
		this.bts = bts;
	}

	public double getArea() {
		return area;
	}

	public void setArea(double area) {
		this.area = area;
	}
	
	
	
	

}
