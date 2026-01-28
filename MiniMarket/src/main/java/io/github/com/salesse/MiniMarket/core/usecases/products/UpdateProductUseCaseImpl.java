package io.github.com.salesse.MiniMarket.core.usecases.products;

import java.util.UUID;

import io.github.com.salesse.MiniMarket.core.entities.Product;
import io.github.com.salesse.MiniMarket.core.exceptions.NotFoundException;
import io.github.com.salesse.MiniMarket.core.gateways.ProductGateway;

public class UpdateProductUseCaseImpl implements UpdateProductUseCase {

	private final ProductGateway productGateway;

	public UpdateProductUseCaseImpl(ProductGateway productGateway) {
		super();
		this.productGateway = productGateway;
	}

	@Override
	public Product execute(UUID id, Product product) {

		Product existingProduct = productGateway.findById(id);

		if (existingProduct == null) {
			throw new NotFoundException("Produto não encontrado");
		}

		existingProduct.setName(product.getName());
		existingProduct.setDescription(product.getDescription());
		existingProduct.setPrice(product.getPrice());

		return productGateway.update(id, product);
	}

}
