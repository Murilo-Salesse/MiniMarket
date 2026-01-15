package io.github.com.salesse.MiniMarket.core.gateways;

import io.github.com.salesse.MiniMarket.core.entities.Product;

public interface ProductGateway {

	Product create(Product product);
}
