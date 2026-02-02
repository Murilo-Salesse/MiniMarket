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

		if (product.getName() != null) {
			existingProduct.setName(product.getName());
		}

		if (product.getDescription() != null) {
			existingProduct.setDescription(product.getDescription());
		}

		if (product.getPrice() != null) {
			existingProduct.setPrice(product.getPrice());
		}

		if (product.getActive() != null) {
			existingProduct.setActive(product.getActive());
		}

		if (product.getCategoryId() != null) {
			existingProduct.setCategoryId(product.getCategoryId());
		}

		return productGateway.update(existingProduct);
	}
}
