package io.github.com.salesse.MiniMarket.core.usecases.categories;

import java.util.UUID;

import io.github.com.salesse.MiniMarket.core.entities.Category;
import io.github.com.salesse.MiniMarket.core.exceptions.BusinessRuleException;
import io.github.com.salesse.MiniMarket.core.gateways.CategoryGateway;
import io.github.com.salesse.MiniMarket.core.gateways.StoreGateway;
import io.github.com.salesse.MiniMarket.infrastructure.security.AuthenticatedUser;

public class CreateCategoryUseCaseImpl implements CreateCategoryUseCase {

	private final CategoryGateway categoryGateway;
	private final StoreGateway storeGateway;

	public CreateCategoryUseCaseImpl(CategoryGateway categoryGateway, StoreGateway storeGateway) {
		this.categoryGateway = categoryGateway;
		this.storeGateway = storeGateway;
	}

	@Override
	public Category execute(Category category) {

		UUID storeIdFromToken = AuthenticatedUser.getStoreId();

		if (storeIdFromToken == null) {
			throw new BusinessRuleException("Usuário não autenticado");
		}

		if (!storeIdFromToken.equals(category.getStoreId())) {
			throw new BusinessRuleException("Usuário não pode criar categorias em outra loja");
		}

		if (!storeGateway.existsById(storeIdFromToken)) {
			throw new BusinessRuleException("Loja não encontrada");
		}

		return categoryGateway.create(category);
	}
}