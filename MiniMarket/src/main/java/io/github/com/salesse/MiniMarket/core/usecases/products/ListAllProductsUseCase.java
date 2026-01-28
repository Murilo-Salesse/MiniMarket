package io.github.com.salesse.MiniMarket.core.usecases.products;

import java.util.List;

import io.github.com.salesse.MiniMarket.core.entities.Product;

public interface ListAllProductsUseCase {

	List<Product> execute();
}
