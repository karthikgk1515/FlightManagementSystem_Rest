package com.fms.dto;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Userdata")
public class Userdata {
	@Id
	@Column(name="user_name")
	private String username;
	@Column(name="user_id")
	private int userid;
	@Column(name="user_type")
	private String usertype;
	
	@Column(name="user_password")
	private String userpassword;
	@Column(name="user_phone",length=10)
	private String userphone;
	@Column(name="user_email")
	private String useremail;
	
	
	public Userdata(int userid, String usertype, String username, String userpassword, String userphone, String useremail) {
		
		this.userid = userid;
		this.usertype = usertype;
		this.username = username;
		this.userpassword = userpassword;
		this.userphone = userphone;
		this.useremail = useremail;
		
	}

	public Userdata() {
		
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getUsertype() {
		return usertype;
	}

	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserpassword() {
		return userpassword;
	}

	public void setUserpassword(String userpassword) {
		this.userpassword = userpassword;
	}

	public String getUserphone() {
		return userphone;
	}

	public void setUserphone(String userphone) {
		this.userphone = userphone;
	}

	public String getUseremail() {
		return useremail;
	}

	public void setUseremail(String useremail) {
		this.useremail = useremail;
	}

	@Override
	public String toString() {
		return "Userdata [username=" + username + ", userid=" + userid + ", usertype=" + usertype + ", userpassword="
				+ userpassword + ", userphone=" + userphone + ", useremail=" + useremail + "]";
	}




	
}
	