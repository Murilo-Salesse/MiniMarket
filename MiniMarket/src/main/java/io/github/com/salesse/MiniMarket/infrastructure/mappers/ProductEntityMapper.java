package io.github.com.salesse.MiniMarket.infrastructure.mappers;

import io.github.com.salesse.MiniMarket.core.entities.Product;
import io.github.com.salesse.MiniMarket.infrastructure.persistence.ProductEntity;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ProductEntityMapper {

	// Converte de Entity para Dominio puro
	public static Product toDomain(ProductEntity entity) {

		return new Product(entity.getId(), entity.getStoreId(), entity.getCategoryId(), entity.getName(),
				entity.getDescription(), entity.getPrice(), entity.getActive(), entity.getCreatedAt(),
				entity.getDeletedAt());
	}

	// Converte de Entidade do banco para Response (saida)
	public static ProductEntity toEntity(Product p) {

		ProductEntity entity = new ProductEntity();
		entity.setId(p.getId());
		entity.setStoreId(p.getStoreId());
		entity.setCategoryId(p.getCategoryId());
		entity.setName(p.getName());
		entity.setDescription(p.getDescription());
		entity.setPrice(p.getPrice());
		entity.setActive(p.getActive());
		entity.setCreatedAt(p.getCreatedAt());
		entity.setDeletedAt(p.getDeletedAt());

		return entity;
	}
}
