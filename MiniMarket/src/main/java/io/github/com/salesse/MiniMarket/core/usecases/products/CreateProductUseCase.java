package io.github.com.salesse.MiniMarket.core.usecases.products;

import io.github.com.salesse.MiniMarket.core.entities.Product;

public interface CreateProductUseCase {

	Product execute(Product product);
}
