package com.spring.rest.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spring.rest.model.Sigerate;
import com.spring.rest.model.User;
import com.spring.rest.service.SigerateService;
import com.spring.rest.service.UserService;

@RestController
public class SigerateController {

	SigerateService sigerateService = new SigerateService();
	UserService userService = new UserService();	
	
	
	@RequestMapping(value="/sigerate/{id}" , method=RequestMethod.GET , headers="Accept=application/json")
	public Sigerate getSingleSigerate(@PathVariable int id)
	{
		Sigerate sig = sigerateService.getSigerateSigerate(id);
		return sig;
	}
	
	@RequestMapping( value="/sigerates" , method=RequestMethod.GET , headers = "Accept=application/json")
	public List<Sigerate> getSigerates()
	{
		List<Sigerate> list = sigerateService.getAllSigerates(); 
		return list;		
	}
		
	
	@RequestMapping( value="user/{id}" , method=RequestMethod.GET , headers="Accept=application/json")
	public User getSingleUser(@PathVariable int id)
	{
		User user = userService.getSingleUser(id);
		return user;
	}
	
	@RequestMapping(value="/users" , method=RequestMethod.GET , headers="Accept=application/json")
	public List<User> getUsers()
	{
		List<User> users = userService.getAllUsers();
		return users;
	}
	
	
	
}
