package io.github.com.salesse.MiniMarket.infrastructure.dtos.responses;

import java.math.BigDecimal;
import java.util.UUID;

public class ProductResponse {

	private UUID id;
	private UUID storeId;
	private UUID categoryId;
	private String name;
	private String description;
	private BigDecimal price;
	private Boolean active;

	public ProductResponse() {
		super();
	}

	public ProductResponse(UUID id, UUID storeId, UUID categoryId, String name, String description, BigDecimal price,
			Boolean active) {
		super();
		this.id = id;
		this.storeId = storeId;
		this.categoryId = categoryId;
		this.name = name;
		this.description = description;
		this.price = price;
		this.active = active;
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

}
