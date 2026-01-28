package io.github.com.salesse.MiniMarket.core.gateways;

import java.util.List;
import java.util.UUID;

import io.github.com.salesse.MiniMarket.core.entities.Product;

public interface ProductGateway {

	Product create(Product product);

	Product findById(UUID product);

	Product update(UUID id, Product product);

	List<Product> findByName(String name);

	List<Product> listAll();
}
