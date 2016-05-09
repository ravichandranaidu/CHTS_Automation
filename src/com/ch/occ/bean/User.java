package com.ch.occ.bean;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class User {

	String firstName = "";

	String lastName = "";

	String email = "";

	String password = "";

	String confirmPassword = "";

	public User(String[] data) {
		firstName = data[0];
		lastName = data[1];
		email = random()+ data[2];
		password = data[3];
		confirmPassword = data[3];
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	  public static String random()
	    {
	        Date date = new Date();
	        DateFormat df = new SimpleDateFormat("dmMM");
	        String str = df.format(date);
	        return str;
	    }
}
