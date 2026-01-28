package io.github.com.salesse.MiniMarket.core.usecases.products;

import java.util.List;

import io.github.com.salesse.MiniMarket.core.entities.Product;
import io.github.com.salesse.MiniMarket.core.gateways.ProductGateway;

public class ListAllProductsUseCaseImpl implements ListAllProductsUseCase {

	private final ProductGateway productGateway;

	public ListAllProductsUseCaseImpl(ProductGateway productGateway) {
		super();
		this.productGateway = productGateway;
	}

	@Override
	public List<Product> execute() {

		return productGateway.listAll();
	}

}
