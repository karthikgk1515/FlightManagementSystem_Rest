package com.fms.service;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fms.dto.Userdata;
import com.fms.repository.UserRepository;
@Service
public class UserService implements UserServiceI
{
     @Autowired
     UserRepository udao;
 

	public void setUdao(UserRepository udao) { this.udao=udao; }
     

     @Transactional
     public Userdata addUser(Userdata user)
     {
    	 user.setUsertype("customer");
    	 return udao.save(user);
     }
     

    
     @Transactional
     public String LoginUser(Userdata u)
     {
    	
     	String usertype=udao.findByusertype(u.getUsername(),u.getUserpassword());
     	if(usertype.equalsIgnoreCase("admin"))
     			{
     				 return "admin";
     			}
     	else if(usertype.equalsIgnoreCase("customer"))
     			{
     			 return "customer";
     			}
     	else
     		 return "invalid";
     
     }
     
  
 
}
