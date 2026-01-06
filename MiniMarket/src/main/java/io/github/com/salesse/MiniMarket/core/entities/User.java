package io.github.com.salesse.MiniMarket.core.entities;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

public class User {

	private UUID id;
	private UUID storeId;
	private String name;
	private String email;
	private String phone;
	private String password;
	private Boolean active;
	private LocalDateTime createdAt;
	private LocalDateTime deletedAt;

	public User() {
		super();
	}

	public User(UUID id, UUID storeId, String name, String email, String phone, String password, Boolean active,
			LocalDateTime createdAt, LocalDateTime deletedAt) {
		super();
		this.id = id;
		this.storeId = storeId;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.password = password;
		this.active = active;
		this.createdAt = createdAt;
		this.deletedAt = deletedAt;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getDeletedAt() {
		return deletedAt;
	}

	public void setDeletedAt(LocalDateTime deletedAt) {
		this.deletedAt = deletedAt;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Users [id=" + id + ", storeId=" + storeId + ", name=" + name + ", email=" + email + ", phone=" + phone
				+ ", password=" + password + ", active=" + active + ", createdAt=" + createdAt + ", deletedAt="
				+ deletedAt + "]";
	}

}
