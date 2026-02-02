package io.github.com.salesse.MiniMarket.core.entities;

import java.util.Objects;
import java.util.UUID;

public class Stock {

	private UUID id;
	private UUID storeId;
	private UUID productId;
	private Integer quantity;
	private Integer minQuantity;

	public Stock() {
		super();
	}

	public Stock(UUID id, UUID storeId, UUID productId, Integer quantity, Integer minQuantity) {
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
		Stock other = (Stock) obj;
		return Objects.equals(id, other.id);
	}

}
