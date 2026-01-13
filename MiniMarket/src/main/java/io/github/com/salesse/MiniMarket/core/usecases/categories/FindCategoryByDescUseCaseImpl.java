package io.github.com.salesse.MiniMarket.core.usecases.categories;

import java.util.List;

import io.github.com.salesse.MiniMarket.core.entities.Category;
import io.github.com.salesse.MiniMarket.core.gateways.CategoryGateway;

public class FindCategoryByDescUseCaseImpl implements FindCategoryByDescUseCase {

	private final CategoryGateway categoryGateway;

	public FindCategoryByDescUseCaseImpl(CategoryGateway categoryGateway) {
		super();
		this.categoryGateway = categoryGateway;
	}

	@Override
	public List<Category> execute(String desc) {
		return categoryGateway.findByDesc(desc);
	}

}
