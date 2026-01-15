package io.github.com.salesse.MiniMarket.core.usecases.products;

import java.util.UUID;

import io.github.com.salesse.MiniMarket.core.entities.Category;
import io.github.com.salesse.MiniMarket.core.entities.Product;
import io.github.com.salesse.MiniMarket.core.exceptions.BusinessRuleException;
import io.github.com.salesse.MiniMarket.core.gateways.CategoryGateway;
import io.github.com.salesse.MiniMarket.core.gateways.ProductGateway;
import io.github.com.salesse.MiniMarket.core.gateways.StoreGateway;
import io.github.com.salesse.MiniMarket.infrastructure.security.AuthenticatedUser;

public class CreateProductUseCaseImpl implements CreateProductUseCase {

	private final ProductGateway productGateway;
	private final StoreGateway storeGateway;
	private final CategoryGateway categoryGateway;

	public CreateProductUseCaseImpl(ProductGateway productGateway, StoreGateway storeGateway,
			CategoryGateway categoryGateway) {
		super();
		this.productGateway = productGateway;
		this.storeGateway = storeGateway;
		this.categoryGateway = categoryGateway;
	}

	@Override
	public Product execute(Product product) {

		UUID storeIdFromToken = AuthenticatedUser.getStoreId();
		if (!storeGateway.existsById(storeIdFromToken)) {
			throw new BusinessRuleException("Loja não encontrada");
		}

		
		Category category = categoryGateway.findById(product.getCategoryId());		
		if (!category.getStoreId().equals(storeIdFromToken)) {
			throw new BusinessRuleException("Usuario não pode cadastrar categoria nesta loja");
		}

		product.setStoreId(storeIdFromToken);

		return productGateway.create(product);
	}

}
