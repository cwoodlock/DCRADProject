package com.geog.DAO;

import java.sql.*;
import java.util.*;
import javax.naming.*;
import javax.sql.DataSource;

import com.geog.Model.Country;
import com.geog.Model.Region;

public class DAO {
	private DataSource mysqlDS;
	
	//Constructor
	public DAO() throws Exception {
		Context context = new InitialContext();
		String jndiName = "java:comp/env/jdbc/geography";
		mysqlDS = (DataSource) context.lookup(jndiName);
	}

	public ArrayList<Country> loadCountries() throws SQLException {
		ArrayList<Country> countries = new ArrayList<Country>();
		
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		
		myConn = mysqlDS.getConnection();
		myStmt = myConn.createStatement();
		myRs = myStmt.executeQuery("SELECT * FROM COUNTRY");
		
		// process result set
		while(myRs.next()) {
			//Create a new Country Object
			Country country = new Country();
			
			//retrieve data from result set
			country.setCode(myRs.getString("co_code"));
			country.setName(myRs.getString("co_name"));
			country.setDetails(myRs.getString("co_details"));
			
			countries.add(country);

		}
		return countries;
	}
	
	public void addCountry(Country country) throws Exception {
		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		
		myConn = mysqlDS.getConnection();
		
		String sql = "insert into country values (?, ?, ?)";
		myStmt = myConn.prepareStatement(sql);
		
		myStmt.setString(1, country.getCode());
		myStmt.setString(2, country.getName());
		myStmt.setString(3, country.getDetails());
	
		myStmt.execute();			
	}
	
	public ArrayList<Region> loadRegion() throws SQLException {
		ArrayList<Region> regions = new ArrayList<Region>();
		
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		
		myConn = mysqlDS.getConnection();
		myStmt = myConn.createStatement();
		myRs = myStmt.executeQuery("SELECT * FROM REGION");
		
		// process result set
		while(myRs.next()) {
			//Create a new Country Object
			Region region = new Region();
			
			//retrieve data from result set
			region.setCode(myRs.getString("co_code"));
			region.setRegCode(myRs.getString("reg_code"));
			region.setRegDetails(myRs.getString("reg_desc"));
			region.setRegName(myRs.getString("reg_name"));
			
			regions.add(region);

		}
		return regions;
	}
	
	public void addRegion(Region region) throws Exception {
		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		
		myConn = mysqlDS.getConnection();
		
		String sql = "insert into country values (?, ?, ?, ?)";
		myStmt = myConn.prepareStatement(sql);
		
		myStmt.setString(1, region.getCode());
		myStmt.setString(2, region.getRegCode());
		myStmt.setString(3, region.getRegName());
		myStmt.setString(4, region.getRegDetails());
		
		myStmt.execute();			
	}
}
