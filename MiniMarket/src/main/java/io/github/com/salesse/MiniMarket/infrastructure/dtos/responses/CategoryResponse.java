package io.github.com.salesse.MiniMarket.infrastructure.dtos.responses;

import java.util.UUID;

public class CategoryResponse {

	private UUID id;
	private UUID storeId;
	private String description;

	public CategoryResponse() {
		super();
	}

	public CategoryResponse(UUID id, UUID storeId, String description) {
		super();
		this.id = id;
		this.storeId = storeId;
		this.description = description;
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

}
