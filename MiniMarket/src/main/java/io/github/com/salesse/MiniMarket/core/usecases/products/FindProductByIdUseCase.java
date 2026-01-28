package io.github.com.salesse.MiniMarket.core.usecases.products;

import java.util.UUID;

import io.github.com.salesse.MiniMarket.core.entities.Product;

public interface FindProductByIdUseCase {

	Product execute(UUID id);
}
