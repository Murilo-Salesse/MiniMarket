package io.github.com.salesse.MiniMarket.core.usecases.categories;

import java.util.UUID;

import io.github.com.salesse.MiniMarket.core.entities.Category;

public interface UpdateCategorieUseCase {

	Category execute(UUID id, Category category);
}
