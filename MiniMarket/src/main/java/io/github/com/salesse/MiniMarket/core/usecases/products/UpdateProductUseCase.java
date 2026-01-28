package io.github.com.salesse.MiniMarket.core.usecases.products;

import java.util.UUID;

import io.github.com.salesse.MiniMarket.core.entities.Product;

public interface UpdateProductUseCase {

	Product execute(UUID id, Product product);
}
