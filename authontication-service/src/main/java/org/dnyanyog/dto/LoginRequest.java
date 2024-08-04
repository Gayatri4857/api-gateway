package org.dnyanyog.dto;

import org.springframework.stereotype.Component;

@Component
public class LoginRequest {
	
	private String username="Admin";
	private String password="Admin123";

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
