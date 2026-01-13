package io.github.com.salesse.MiniMarket.core.gateways;

import java.util.List;
import java.util.UUID;

import io.github.com.salesse.MiniMarket.core.entities.Category;

public interface CategoryGateway {

	Category create(Category category);
	Category findById(UUID id);
	Category update(UUID id, Category category);
	List<Category> findAll();
	List<Category> findByDesc(String desc);
	Void delete(UUID id);
}
