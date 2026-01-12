package io.github.com.salesse.MiniMarket.infrastructure.dtos.responses;

import java.util.Set;
import java.util.UUID;

public class LoginResponse {

	private UUID userId;
	private String name;
	private String email;
	private String token;
	private Set<String> roles;

	public LoginResponse() {
		super();
	}

	public LoginResponse(UUID userId, String name, String email, String token, Set<String> roles) {
		super();
		this.userId = userId;
		this.name = name;
		this.email = email;
		this.token = token;
		this.roles = roles;
	}

	public UUID getUserId() {
		return userId;
	}

	public void setUserId(UUID userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<String> getRoles() {
		return roles;
	}

	public void setRoles(Set<String> roles) {
		this.roles = roles;
	}

}
