package io.github.com.salesse.MiniMarket.infrastructure.gateway;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import io.github.com.salesse.MiniMarket.core.entities.Product;
import io.github.com.salesse.MiniMarket.core.exceptions.NotFoundException;
import io.github.com.salesse.MiniMarket.core.gateways.ProductGateway;
import io.github.com.salesse.MiniMarket.infrastructure.mappers.ProductEntityMapper;
import io.github.com.salesse.MiniMarket.infrastructure.persistence.ProductEntity;
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

	@Override
	public List<Product> listAll() {
		return productRepository.findAll().stream().map(ProductEntityMapper::toDomain).collect(Collectors.toList());
	}

	@Override
	public List<Product> findByName(String name) {

		return productRepository.findProductsName(name).stream().map(ProductEntityMapper::toDomain)
				.collect(Collectors.toList());

	}

	@Override
	public Product findById(UUID id) {

		return ProductEntityMapper
				.toDomain(productRepository.findById(id).orElseThrow(() -> new NotFoundException("ID não encontrado")));
	}

	@Override
	public Product update(UUID id, Product product) {

		ProductEntity founded = productRepository.findById(id)
				.orElseThrow(() -> new NotFoundException("ID não encontrado"));

		founded.setStoreId(product.getStoreId());
		founded.setName(product.getName());
		founded.setDescription(product.getDescription());
		founded.setPrice(product.getPrice());
		founded.setActive(product.getActive());
		founded.setDeletedAt(product.getDeletedAt());

		productRepository.save(founded);

		return ProductEntityMapper.toDomain(founded);

	}

}
