package io.github.com.salesse.MiniMarket.core.usecases.categories;

import java.util.UUID;

import io.github.com.salesse.MiniMarket.core.entities.Category;
import io.github.com.salesse.MiniMarket.core.exceptions.BusinessRuleException;
import io.github.com.salesse.MiniMarket.core.exceptions.NotFoundException;
import io.github.com.salesse.MiniMarket.core.gateways.CategoryGateway;
import io.github.com.salesse.MiniMarket.infrastructure.security.AuthenticatedUser;

public class UpdateCategorieUseCaseImpl implements UpdateCategorieUseCase {

	private final CategoryGateway categoryGateway;

	public UpdateCategorieUseCaseImpl(CategoryGateway categoryGateway) {
		super();
		this.categoryGateway = categoryGateway;
	}

	@Override
	public Category execute(UUID id, Category category) {

		Category existingCategory = categoryGateway.findById(id);

		if (existingCategory == null) {
			throw new NotFoundException("Categoria não encontrada");
		}

		UUID storeIdFromToken = AuthenticatedUser.getStoreId();

		if (!existingCategory.getStoreId().equals(storeIdFromToken)) {
			throw new BusinessRuleException("Você não pode alterar categorias de outra loja");
		}

		existingCategory.setDescription(category.getDescription());

		return categoryGateway.update(id, existingCategory);
	}

}
