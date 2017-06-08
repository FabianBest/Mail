package com.java.korki.datamodel;

import java.util.HashMap;
import java.util.Map;

public class UsersHandler {
	Map<String, String> usersList = new HashMap<>();
	Map<Map, String> directorsList = new HashMap<>();
	
	public UsersHandler(){
		usersList.put("Admin", "Admin");
		usersList.put("Check", "Check");
		directorsList.put(usersList,"Admin");
	}
	
}
