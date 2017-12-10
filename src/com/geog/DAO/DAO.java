package com.geog.DAO;

import java.sql.*;
import java.util.*;
import javax.naming.*;
import javax.sql.DataSource;



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
			Country country = new Country();
			country.setCode(myRs.getString(""))
		}
	}
}
