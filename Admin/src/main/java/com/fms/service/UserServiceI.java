package com.fms.service;

import java.util.List;

import com.fms.dto.Userdata;

public interface UserServiceI {
	public Userdata viewUser(String username);
	 public List<Userdata> viewUser();
	 public Userdata addUser(Userdata user);
	 public Userdata updateUser(Userdata u);
	 public void deleteUser(int userid);
	 public String LoginUser(Userdata u);
}
