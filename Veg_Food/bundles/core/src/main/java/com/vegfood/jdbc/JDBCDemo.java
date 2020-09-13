package com.vegfood.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.day.commons.datasource.poolservice.DataSourceNotFoundException;
import com.day.commons.datasource.poolservice.DataSourcePool;

@Component(service = CRUD_Operations.class, name = "JDBC Service - CRUD")
public class JDBCDemo implements CRUD_Operations {

	@Reference
	private DataSourcePool sourcePool;

	
	private Connection getConnection() throws SQLException {
		
//		Connection connection;
//		DataSource dataSource;
		try {
			DataSource dataSource = (DataSource) sourcePool.getDataSource("JDBCDemo");
			/* Here - I'm getting NullPointer Exception */
			System.out.println(dataSource.toString());
			Connection connection = dataSource.getConnection("root", "windows");
			return connection;
		} catch (DataSourceNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("JDBC - Catch Block");
			return null;
		}
		
		
		
	}
	public static void main(String[] args) throws SQLException, DataSourceNotFoundException {
		JDBCDemo jdbc = new JDBCDemo();
		jdbc.retriveUserInfo();
	}
	
	@Override
	public List<User> retriveUserInfo(){
		List<User> usList=new ArrayList<>();
		Statement smt;
		ResultSet rs;
		Connection con;
		try {
			con = getConnection();
			smt=con.createStatement();
			rs=smt.executeQuery("SELECT * FROM user.user_tbl");
			while(rs.next()) {
				User u=new User();
				u.setId(rs.getInt(1));
				u.setName(rs.getString(2));
				u.setAge(rs.getInt(3));
				u.setMail(rs.getString(4));
				System.out.println(u);
				usList.add(u);
		}
		}catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return usList;
	}
}
