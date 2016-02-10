package com.spring.rest.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.spring.rest.model.Sigerate;
import com.spring.rest.util.DbUtility;


@Service
public class SigerateService {
	
	private Connection connection;
		
	public SigerateService()
	{
		connection = DbUtility.getConnection();
	}
			
	
	
	
	public List<Sigerate> getAllSigerates()
	{		
		List<Sigerate> sigerates = new ArrayList<Sigerate>();		
		try 
		{
			Statement stm = connection.createStatement();
			String query = "SELECT * FROM `tbl_sigerates`";
			ResultSet rs = stm.executeQuery(query);
			while(rs.next())
			{
				Sigerate sig = new Sigerate();
				sig.setSigerateId(rs.getInt("sigerate_id"));
				sig.setSigerateBrand(rs.getString("sigerate_brand"));
				sigerates.add(sig);
			}			
		} 
		catch (SQLException e) 
		{			
			e.printStackTrace();
		}
			
		return sigerates;		
	}
	
	
	public Sigerate getSigerateSigerate(int sigerateId)
	{
		Sigerate sig = new Sigerate();		
		String query = "SELECT * FROM `tbl_sigerates` WHERE `sigerate_id`=?";		
		try 
		{
			PreparedStatement p = connection.prepareStatement(query);
			p.setInt(1, sigerateId);
			ResultSet rs = p.executeQuery();
			
			if(rs.next())
			{
				sig.setSigerateId(rs.getInt("sigerate_id"));
				sig.setSigerateBrand(rs.getString("sigerate_brand"));
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}				
		return sig;
	}

}
