package com.sqlex.project.sqldemo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PersonDAO {
	
	public void insert(String name, int age) throws Exception {
		Connection con = MySqlConnect.getConnection();
		String insertsql = "insert into application_user(name,age) values (?,?)";
		PreparedStatement ps = con.prepareStatement(insertsql);
		ps.setString(1, name);
		ps.setInt(2, age);
		ps.executeUpdate();
	}
	
	// Method to update values in Database
	public void update(String name, int age, int id) throws Exception {
		Connection con = MySqlConnect.getConnection();
		String updatesql = "update application_user set name=?, age=? where id=?";
		PreparedStatement ps1 = con.prepareStatement(updatesql);
		ps1.setString(1, name);
		ps1.setInt(2, age);
		ps1.setInt(3, id);
		ps1.executeUpdate();
	}
	
	
	
	public void getAll() throws Exception {
		Connection con = MySqlConnect.getConnection();
		PreparedStatement ps = con.prepareStatement(RETRIEVE_SQL);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next())
		{
			System.out.println("Name: " + rs.getString("name") + " ;Age: " + rs.getInt("age"));
		}
	}

	public static final String INSERT_SQL = "insert into application_user(name,age) values (?,?)";

	public static final String RETRIEVE_SQL = "select id, name, age from application_user";

	
}