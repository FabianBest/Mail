package com.java.korki.datamodel;

import com.korki.java.interfaces.Users;

public class Director implements Users {
	
	@Override
	public boolean SignIn(String login, String password) {
		String checkLogin;
		System.out.println("Signning in...");
		if(usersHandler.usersList.containsKey(login)) {
			checkLogin = usersHandler.usersList.get(login);
			System.out.println("Hello " + checkLogin + " checking password...");
			if(checkLogin.equals(password)){
				return true;
			} else return false;
		} else return false;
	}

	@Override
	public void SignOut() {
		// TODO Auto-generated method stub
		
	}
}
