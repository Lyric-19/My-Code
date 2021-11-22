package com.kkb.task010203;

public class UserService {

	public boolean login(String userName,int pin) {
		if("admin".equals(userName) && 123==pin) {
				return true;
		} 
		return false;
	}

}
