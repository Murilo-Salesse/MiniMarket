package io.github.com.salesse.MiniMarket.infrastructure.mappers;

import java.util.List;

import io.github.com.salesse.MiniMarket.core.entities.Product;
import io.github.com.salesse.MiniMarket.infrastructure.dtos.requests.ProductRequest;
import io.github.com.salesse.MiniMarket.infrastructure.dtos.responses.ProductResponse;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ProductMapper {

	// Transforma request em entidade pura
	public static Product toDomain(ProductRequest request) {

		return new Product(null, request.getStoreId(), request.getCategoryId(), request.getName(),
				request.getDescription(), request.getPrice(), true, null, null);
	}

	// Transforma entidade pura em response
	public static ProductResponse toProductResponse(Product p) {
		return new ProductResponse(p.getId(), p.getStoreId(), p.getCategoryId(), p.getName(), p.getDescription(),
				p.getPrice(), p.getActive());
	}

	public static List<ProductResponse> toProductResponseList(List<Product> products) {
		return products.stream().map(ProductMapper::toProductResponse).toList();
	}
}
