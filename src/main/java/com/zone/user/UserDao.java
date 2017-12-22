package com.zone.user;

import java.util.List;

public interface UserDao {

	public void saveOrUpdate(UserModel user);
	public String login(String username, String password);
	public UserModel findbyuserName(String username);
	public List<UserModel> getUserRegister(int clientid);
	public String checkUserName(String username);
	
	//===Check User Name from User Dao ========//
	
	public String CheckUser(int clientid ,String username);
	
}
