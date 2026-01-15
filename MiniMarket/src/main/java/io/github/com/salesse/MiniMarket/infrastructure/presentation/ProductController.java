package io.github.com.salesse.MiniMarket.infrastructure.presentation;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.com.salesse.MiniMarket.core.entities.Product;
import io.github.com.salesse.MiniMarket.core.usecases.products.CreateProductUseCase;
import io.github.com.salesse.MiniMarket.infrastructure.dtos.requests.ProductRequest;
import io.github.com.salesse.MiniMarket.infrastructure.mappers.ProductMapper;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/products")
public class ProductController {

	private final CreateProductUseCase createProductUseCase;

	public ProductController(CreateProductUseCase createProductUseCase) {
		super();
		this.createProductUseCase = createProductUseCase;
	}

	@PostMapping("/create")
	@PreAuthorize("hasAnyRole('ADMIN', 'FUNCIONARIO')")
	public ResponseEntity<Map<String, Object>> createProduct(@Valid @RequestBody ProductRequest request) {

		Product newProduct = createProductUseCase.execute(ProductMapper.toDomain(request));

		Map<String, Object> data = Map.of("message", "Produto criado com sucesso.", "product",
				ProductMapper.toProductResponse(newProduct));

		return ResponseEntity.status(HttpStatus.CREATED).body(Map.of("data", data));
	}
}
