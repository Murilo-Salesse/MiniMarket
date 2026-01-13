package io.github.com.salesse.MiniMarket.core.usecases.categories;

import java.util.UUID;

import io.github.com.salesse.MiniMarket.core.entities.Category;
import io.github.com.salesse.MiniMarket.core.gateways.CategoryGateway;

public class FindCategoryByIdUseCaseImpl implements FindCategoryByIdUseCase{

	private final CategoryGateway categoryGateway;

	public FindCategoryByIdUseCaseImpl(CategoryGateway categoryGateway) {
		super();
		this.categoryGateway = categoryGateway;
	}

	@Override
	public Category execute(UUID id) {
		return categoryGateway.findById(id);
	}
	
}
