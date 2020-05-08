package com.fms.service;
import java.util.List;

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
     
     @Override
     public Userdata viewUser(String username)
     {
    	 return udao.findById(username).get();
     }
     
     @Override
     public List<Userdata> viewUser()
     {
    	 return udao.findAll();
     }
     
     @Override
     public Userdata addUser(Userdata user)
     {
    	 return udao.save(user);
     }
     
     @Override
     public Userdata updateUser(Userdata u)
     {
    		Userdata ud=udao.findById(u.getUserid()).get();
    		if(ud!=null)
    		{
    			ud.setUsername(u.getUsername());
    			ud.setUserpassword(u.getUserpassword());
    			ud.setUserphone(u.getUserphone());
    			ud.setUseremail(u.getUseremail());
    		}
    		return udao.save(ud);
    	 
     }
     
     @Override
     public void deleteUser(int userid)
     {
    	  udao.deleteById(userid);
     }
    
     @Override
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
