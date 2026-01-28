package io.github.com.salesse.MiniMarket.core.usecases.products;

import java.util.UUID;

import io.github.com.salesse.MiniMarket.core.entities.Product;
import io.github.com.salesse.MiniMarket.core.gateways.ProductGateway;

public class FindProductByIdUseCaseImpl implements FindProductByIdUseCase {

	private final ProductGateway productGateway;

	public FindProductByIdUseCaseImpl(ProductGateway productGateway) {
		super();
		this.productGateway = productGateway;
	}

	@Override
	public Product execute(UUID id) {
		return productGateway.findById(id);
	}

}
