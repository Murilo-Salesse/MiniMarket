package io.github.com.salesse.MiniMarket.core.entities;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

public class Stores {

	private UUID id;
	private String name;
	private String cnpj;
	private String address;
	private String phone;
	private LocalDateTime createdAt;

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
		Stores other = (Stores) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Stores [id=" + id + ", name=" + name + ", cnpj=" + cnpj + ", address=" + address + ", phone=" + phone
				+ ", createdAt=" + createdAt + "]";
	}

}
