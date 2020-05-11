package com.fms.service;

import java.util.List;

import com.fms.dto.Userdata;

public interface UserServiceI {
	 public Userdata addUser(Userdata user);
	 public String LoginUser(Userdata u);
}
