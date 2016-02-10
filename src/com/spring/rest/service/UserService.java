package com.spring.rest.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.spring.rest.model.User;
import com.spring.rest.util.DbUtility;

@Service
public class UserService {

	private Connection connection;
	
	public UserService()
	{
		connection = DbUtility.getConnection();
	}
	
	public List<User> getAllUsers()
	{
		List<User> users = new ArrayList<User>();
		
		try
		{
			Statement stm = connection.createStatement();
			String query = "SELECT * FROM `tbl_users`";		
			ResultSet rs = stm.executeQuery(query);
			
			while(rs.next())
			{
				User user = new User();
				user.setUserId(rs.getInt("userid"));
				user.setUserName(rs.getString("username"));
				user.setPassword(rs.getString("password"));
		        users.add(user);		
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}		
		
		return users;
	}
	
	public User getSingleUser(int userId)
	{
		User user = new User();
		String query = "SELECT * FROM `tbl_users` WHERE `userid`=?";
		try 
		{
			PreparedStatement p = connection.prepareStatement(query);
			p.setInt(1, userId);
			
			ResultSet rs = p.executeQuery();
			
			if(rs.next())
			{
				user.setUserId(rs.getInt("userid"));
				user.setUserName(rs.getString("username"));
				user.setPassword(rs.getString("password"));
			}
		} 
		catch (SQLException e) 
		{			
			e.printStackTrace();
		}	
		
		return user;
	}
	
	
}
