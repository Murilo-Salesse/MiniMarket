package io.github.com.salesse.MiniMarket.infrastructure.mappers;

import io.github.com.salesse.MiniMarket.core.entities.Category;
import io.github.com.salesse.MiniMarket.infrastructure.persistence.CategoryEntity;
import lombok.experimental.UtilityClass;

@UtilityClass
public class CategoryEntityMapper {

	// Converte de CategoryEntity para Dominio puro
	public static Category toDomain(CategoryEntity entity) {
		return new Category(entity.getId(), entity.getStoreId(), entity.getDescription(), entity.getCreatedAt(),
				entity.getDeletedAt());
	}

	// Converte de Entidade do banco para CategoryResponse (saida)
	public static CategoryEntity toEntity(Category category) {
		CategoryEntity entity = new CategoryEntity();
		entity.setId(category.getId());
		entity.setStoreId(category.getStoreId());
		entity.setDescription(category.getDescription());
		entity.setCreatedAt(category.getCreatedAt());
		entity.setDeletedAt(category.getDeletedAt());

		return entity;
	}
}
