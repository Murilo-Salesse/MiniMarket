package io.github.com.salesse.MiniMarket.core.usecases.categories;

import java.util.List;

import io.github.com.salesse.MiniMarket.core.entities.Category;

public interface FindCategoryByDescUseCase {

	List<Category> execute(String desc);
}
