package io.github.com.salesse.MiniMarket.core.usecases.categories;

import java.util.UUID;

import io.github.com.salesse.MiniMarket.core.gateways.CategoryGateway;

public class DeleteCategorieByIdUseCaseImpl implements DeleteCategorieByIdUseCase {

	private final CategoryGateway categoryGateway;

	public DeleteCategorieByIdUseCaseImpl(CategoryGateway categoryGateway) {
		super();
		this.categoryGateway = categoryGateway;
	}

	@Override
	public Void execute(UUID id) {
		return categoryGateway.delete(id);
	}

}
