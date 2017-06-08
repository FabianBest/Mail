package com.korki.java.interfaces;

import com.java.korki.datamodel.UsersHandler;

public interface Users {

	public UsersHandler usersHandler = new UsersHandler();
	
	public boolean SignIn(String login, String password);
	public void SignOut();
	
}
