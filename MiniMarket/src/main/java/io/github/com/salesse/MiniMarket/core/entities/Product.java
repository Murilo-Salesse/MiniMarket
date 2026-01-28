package io.github.com.salesse.MiniMarket.core.entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

import io.github.com.salesse.MiniMarket.core.exceptions.BusinessRuleException;

public class Product {

	private UUID id;
	private UUID storeId;
	private UUID categoryId;
	private String name;
	private String description;
	private BigDecimal price;
	private Boolean active;
	private LocalDateTime createdAt;
	private LocalDateTime deletedAt;

	public Product() {
		super();
	}

	public Product(UUID id, UUID storeId, UUID categoryId, String name, String description, BigDecimal price,
			Boolean active, LocalDateTime createdAt, LocalDateTime deletedAt) {
		super();
		this.id = id;
		this.storeId = storeId;
		this.categoryId = categoryId;
		this.name = name;
		this.description = description;
		this.price = price;
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

	public UUID getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(UUID categoryId) {
		this.categoryId = categoryId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
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
		Product other = (Product) obj;
		return Objects.equals(id, other.id);
	}

	public void deactivate() {
		if (!this.active) {
			throw new BusinessRuleException("Produto já está inativo");
		}
		this.active = false;
		this.deletedAt = LocalDateTime.now();
	}
}
