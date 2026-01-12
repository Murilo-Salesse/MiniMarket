package io.github.com.salesse.MiniMarket.core.entities;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

import io.github.com.salesse.MiniMarket.core.exceptions.BusinessRuleException;

public class User {

	private UUID id;
	private UUID storeId;
	private String name;
	private String email;
	private String phone;
	private String password;
	private Boolean active;
	private Set<Role> roles = new HashSet<>();
	private LocalDateTime createdAt;
	private LocalDateTime deletedAt;

	public User() {
		super();
	}

	public User(UUID id, UUID storeId, String name, String email, String phone, String password, Boolean active,
			Set<Role> roles, LocalDateTime createdAt, LocalDateTime deletedAt) {
		super();
		this.id = id;
		this.storeId = storeId;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.password = password;
		this.active = active;
		this.roles = (roles == null) ? new HashSet<>() : new HashSet<>(roles);
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

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
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
		return "User [id=" + id + ", storeId=" + storeId + ", name=" + name + ", email=" + email + ", phone=" + phone
				+ ", password=" + password + ", active=" + active + ", roles=" + roles + ", createdAt=" + createdAt
				+ ", deletedAt=" + deletedAt + "]";
	}

	public void deactivate() {
		if (!this.active) {
			throw new BusinessRuleException("Usuário já está inativo");
		}
		this.active = false;
		this.deletedAt = LocalDateTime.now();
	}

	public void activate() {
		if (this.active) {
			throw new BusinessRuleException("Usuário já está ativo");
		}
		this.active = true;
	}

	public void replaceRoles(Set<Role> newRoles) {

		if (newRoles == null || newRoles.isEmpty()) {
			throw new BusinessRuleException("Usuário deve possuir ao menos uma role");
		}

		this.roles.clear();
		this.roles.addAll(newRoles);
	}

	public void verifyIfIsActive() {
		if (!this.active) {
			throw new BusinessRuleException("Usuário não está ativo");
		}
		return;
	}

}
