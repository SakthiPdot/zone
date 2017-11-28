package com.zone.signup;

import java.util.List;

public interface SignupDao {
	
	public void saveOrUpdate(SignupModel signup);
	public List<SignupModel> getRegister();	
	public String checkUsername(String username);
	public String getlogin(String username, String password);
	public SignupModel getSignupId(int id);
	
	// ======== find by username =========//
	
	public SignupModel findByUsername(String username);
	
	//===== max id get =====//
	public int maxid();
	
}
