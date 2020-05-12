package com.fms;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.fms.dto.Userdata;
import com.fms.repository.UserRepository;
import com.fms.service.UserService;

@SpringBootTest
class AdminApplicationTest {


	@Mock
	private UserRepository udao;
	@InjectMocks
	private UserService userService;
	
	
	@Test
	public void testfindAlluser() {
		List<Userdata> userList=new ArrayList<>();
		userList.add(new Userdata(1,"Admin","sony","sony","809646811","sony@gmail.com"));
		userList.add(new Userdata(2,"customer","preethi","preethi","995938111","preethi@gmail.com"));
		Mockito.when(udao.findAll()).thenReturn(userList);
		List<Userdata> result=udao.findAll();
		assertEquals(2,result.size());
	}
	

}
