package io.github.com.salesse.MiniMarket.infrastructure.mappers;

import java.util.List;

import io.github.com.salesse.MiniMarket.core.entities.Category;
import io.github.com.salesse.MiniMarket.infrastructure.dtos.requests.CategoryRequest;
import io.github.com.salesse.MiniMarket.infrastructure.dtos.requests.CategoryUpdateRequest;
import io.github.com.salesse.MiniMarket.infrastructure.dtos.responses.CategoryResponse;
import lombok.experimental.UtilityClass;

@UtilityClass
public class CategoryMapper {

	// Transforma request em entidade pura
	public static Category toDomain(CategoryRequest request) {
		return new Category(null, request.getStoreId(), request.getDescription(), null, null);
	}
	
	public static Category toDomain(CategoryUpdateRequest request) {
		return new Category(null, null, request.getDescription(), null, null);
	}

	// Transforma entidade pura em response
	public static CategoryResponse toCategoryResponse(Category c) {
		return new CategoryResponse(c.getId(), c.getStoreId(), c.getDescription());
	}

	public static List<CategoryResponse> toCategoryResponseList(List<Category> categories) {
		return categories.stream().map(CategoryMapper::toCategoryResponse).toList();
	}
}
