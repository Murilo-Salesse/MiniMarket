package io.github.com.salesse.MiniMarket.core.usecases.categories;

import java.util.List;

import io.github.com.salesse.MiniMarket.core.entities.Category;
import io.github.com.salesse.MiniMarket.core.gateways.CategoryGateway;

public class ListAllCategoriesUseCaseImpl implements ListAllCategoriesUseCase{

	private final CategoryGateway categoryGateway;

	public ListAllCategoriesUseCaseImpl(CategoryGateway categoryGateway) {
		super();
		this.categoryGateway = categoryGateway;
	}

	@Override
	public List<Category> execute() {
		return categoryGateway.findAll();
	}


	
}
