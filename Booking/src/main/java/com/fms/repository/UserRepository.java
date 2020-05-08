package com.fms.repository;
import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.fms.dto.Userdata;


@Repository
public interface UserRepository extends JpaRepository<Userdata, Serializable>
{
	@Query("select m.usertype from Userdata m where m.username=?1 and m.userpassword=?2")
	String findByusertype(String username, String userpassword);
}
