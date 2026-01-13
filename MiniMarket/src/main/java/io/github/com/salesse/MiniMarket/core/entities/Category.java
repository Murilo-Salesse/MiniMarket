package io.github.com.salesse.MiniMarket.core.entities;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

public class Category {

	private UUID id;
	private UUID storeId;
	private String description;
	private LocalDateTime createdAt;
	private LocalDateTime deletedAt;

	public Category() {
		super();
	}

	public Category(UUID id, UUID storeId, String description, LocalDateTime createdAt, LocalDateTime deletedAt) {
		super();
		this.id = id;
		this.storeId = storeId;
		this.description = description;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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
		Category other = (Category) obj;
		return Objects.equals(id, other.id);
	}

}
