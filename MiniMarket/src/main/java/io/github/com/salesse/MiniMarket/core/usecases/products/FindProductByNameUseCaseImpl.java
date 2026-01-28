package io.github.com.salesse.MiniMarket.core.usecases.products;

import java.util.List;

import io.github.com.salesse.MiniMarket.core.entities.Product;
import io.github.com.salesse.MiniMarket.core.gateways.ProductGateway;

public class FindProductByNameUseCaseImpl implements FindProductByNameUseCase {

	private final ProductGateway productGateway;

	public FindProductByNameUseCaseImpl(ProductGateway productGateway) {
		super();
		this.productGateway = productGateway;
	}

	@Override
	public List<Product> execute(String name) {
		return productGateway.findByName(name);
	}

}
