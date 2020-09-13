package com.law.jdbc;

import java.sql.Connection;

import org.osgi.service.component.annotations.Component;

@Component(service = CRUDOperations.class, name = "JBDC Service ")
public class CRUD_Impl implements CRUDOperations {

	@Override
	public String retrieveBuses() {
		JDBCConnection con = new JDBCConnection();
		Connection dbConnection = con.getDBConnection();
		if(dbConnection != null) {
			return "Connection Established Successfully ..!!";
		}
		else 
		return "Connection Issiue";
	}

}
