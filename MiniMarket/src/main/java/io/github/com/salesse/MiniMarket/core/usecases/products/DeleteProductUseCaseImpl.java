package io.github.com.salesse.MiniMarket.core.usecases.products;

import java.util.UUID;

import io.github.com.salesse.MiniMarket.core.entities.Product;
import io.github.com.salesse.MiniMarket.core.gateways.ProductGateway;

public class DeleteProductUseCaseImpl implements DeleteProductUseCase {

	private final ProductGateway productGateway;

	public DeleteProductUseCaseImpl(ProductGateway productGateway) {
		super();
		this.productGateway = productGateway;
	}

	@Override
	public Void execute(UUID id) {
		Product product = productGateway.findById(id);
		product.deactivate();
		productGateway.update(product);

		return null;
	}

}
