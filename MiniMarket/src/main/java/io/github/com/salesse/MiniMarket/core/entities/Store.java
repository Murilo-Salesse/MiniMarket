package io.github.com.salesse.MiniMarket.core.entities;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

import io.github.com.salesse.MiniMarket.core.exceptions.BusinessRuleException;

public class Store {

	private UUID id;
	private String name;
	private String cnpj;
	private String address;
	private String phone;
	private LocalDateTime createdAt;
	private LocalDateTime deletedAt;
	private boolean active;

	public Store() {
		super();
	}

	public Store(UUID id, String name, String cnpj, String address, String phone, LocalDateTime createdAt,
			LocalDateTime deletedAt, boolean active) {
		super();
		this.id = id;
		this.name = name;
		this.cnpj = cnpj;
		this.address = address;
		this.phone = phone;
		this.createdAt = createdAt;
		this.deletedAt = deletedAt;
		this.active = active;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
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

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
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
		Store other = (Store) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Stores [id=" + id + ", name=" + name + ", cnpj=" + cnpj + ", address=" + address + ", phone=" + phone
				+ ", createdAt=" + createdAt + ", deletedAt=" + deletedAt + ", active=" + active + "]";
	}

	public void deactivate() {
		if (!this.active) {
			throw new BusinessRuleException("Loja já está inativa");
		}
		this.active = false;
		this.deletedAt = LocalDateTime.now();
	}
}
