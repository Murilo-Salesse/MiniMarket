package io.github.com.salesse.MiniMarket.infrastructure.gateway;

import org.springframework.stereotype.Component;

import io.github.com.salesse.MiniMarket.core.entities.Product;
import io.github.com.salesse.MiniMarket.core.gateways.ProductGateway;
import io.github.com.salesse.MiniMarket.infrastructure.mappers.ProductEntityMapper;
import io.github.com.salesse.MiniMarket.infrastructure.repositorys.ProductRepository;

@Component
public class ProductRepositoryGateway implements ProductGateway {

	private final ProductRepository productRepository;

	public ProductRepositoryGateway(ProductRepository productRepository) {
		super();
		this.productRepository = productRepository;
	}

	@Override
	public Product create(Product product) {

		return ProductEntityMapper.toDomain(productRepository.save(ProductEntityMapper.toEntity(product)));
	}

}
