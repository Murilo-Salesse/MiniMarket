package io.github.com.salesse.MiniMarket.core.usecases.categories;

import java.util.List;

import io.github.com.salesse.MiniMarket.core.entities.Category;

public interface ListAllCategoriesUseCase {

	List<Category> execute();
}
