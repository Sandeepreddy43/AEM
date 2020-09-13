package com.law.jdbc;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Reference;

import com.day.commons.datasource.poolservice.DataSourceNotFoundException;
import com.day.commons.datasource.poolservice.DataSourcePool;

//@Component(name = "JDBC Connection")
public class JDBCConnection {
	
	@Reference
	private DataSourcePool pool;
	
	public Connection getDBConnection() {
		try {
			DataSource dataSource = (DataSource) pool.getDataSource("JDBCConnection");
			Connection connection = dataSource.getConnection();
			return connection;
		} catch (DataSourceNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
}
