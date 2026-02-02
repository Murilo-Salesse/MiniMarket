package io.github.com.salesse.MiniMarket.infrastructure.dtos.responses;

import java.util.UUID;

public class StockResponse {

	private UUID id;
	private UUID storeId;
	private UUID productId;
	private Integer quantity;
	private Integer minQuantity;

	public StockResponse() {
		super();
	}

	public StockResponse(UUID id, UUID storeId, UUID productId, Integer quantity, Integer minQuantity) {
		super();
		this.id = id;
		this.storeId = storeId;
		this.productId = productId;
		this.quantity = quantity;
		this.minQuantity = minQuantity;
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

	public UUID getProductId() {
		return productId;
	}

	public void setProductId(UUID productId) {
		this.productId = productId;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Integer getMinQuantity() {
		return minQuantity;
	}

	public void setMinQuantity(Integer minQuantity) {
		this.minQuantity = minQuantity;
	}

}
