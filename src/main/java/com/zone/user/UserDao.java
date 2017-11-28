package com.zone.user;

public interface UserDao {

	public void saveOrUpdate(UserModel user);
	public boolean login(String username, String password);
	public UserModel findbyuserName(String username);
	
}
