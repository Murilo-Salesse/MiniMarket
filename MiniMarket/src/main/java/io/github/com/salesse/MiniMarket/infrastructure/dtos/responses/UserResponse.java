package io.github.com.salesse.MiniMarket.infrastructure.dtos.responses;

import java.util.UUID;

public class UserResponse {

	private UUID id;
	private UUID storeId;
	private String name;
	private String email;
	private String phone;

	public UserResponse() {
		super();
	}

	public UserResponse(UUID id, UUID storeId, String name, String email, String phone) {
		super();
		this.id = id;
		this.storeId = storeId;
		this.name = name;
		this.email = email;
		this.phone = phone;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public UUID getStoreId() {
		return storeId;
	}

	public void setStoreId(UUID storeId) {
		this.storeId = storeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}
