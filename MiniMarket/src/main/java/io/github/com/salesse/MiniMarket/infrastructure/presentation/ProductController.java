package io.github.com.salesse.MiniMarket.infrastructure.presentation;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.github.com.salesse.MiniMarket.core.entities.Product;
import io.github.com.salesse.MiniMarket.core.usecases.products.CreateProductUseCase;
import io.github.com.salesse.MiniMarket.core.usecases.products.DeleteProductUseCase;
import io.github.com.salesse.MiniMarket.core.usecases.products.FindProductByIdUseCase;
import io.github.com.salesse.MiniMarket.core.usecases.products.FindProductByNameUseCase;
import io.github.com.salesse.MiniMarket.core.usecases.products.ListAllProductsUseCase;
import io.github.com.salesse.MiniMarket.core.usecases.products.UpdateProductUseCase;
import io.github.com.salesse.MiniMarket.infrastructure.dtos.requests.ProductRequest;
import io.github.com.salesse.MiniMarket.infrastructure.dtos.requests.ProductUpdateRequest;
import io.github.com.salesse.MiniMarket.infrastructure.mappers.ProductMapper;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/products")
public class ProductController {

	private final CreateProductUseCase createProductUseCase;
	private final ListAllProductsUseCase listAllProductsUseCase;
	private final FindProductByIdUseCase findProductByIdUseCase;
	private final FindProductByNameUseCase findProductByNameUseCase;
	private final UpdateProductUseCase updateProductUseCase;
	private final DeleteProductUseCase deleteProductUseCase;

	public ProductController(CreateProductUseCase createProductUseCase, ListAllProductsUseCase listAllProductsUseCase,
			FindProductByIdUseCase findProductByIdUseCase, FindProductByNameUseCase findProductByNameUseCase,
			UpdateProductUseCase updateProductUseCase, DeleteProductUseCase deleteProductUseCase) {
		super();
		this.createProductUseCase = createProductUseCase;
		this.listAllProductsUseCase = listAllProductsUseCase;
		this.findProductByIdUseCase = findProductByIdUseCase;
		this.findProductByNameUseCase = findProductByNameUseCase;
		this.updateProductUseCase = updateProductUseCase;
		this.deleteProductUseCase = deleteProductUseCase;
	}

	@PostMapping("/create")
	@PreAuthorize("hasAnyRole('ADMIN', 'FUNCIONARIO')")
	public ResponseEntity<Map<String, Object>> createProduct(@Valid @RequestBody ProductRequest request) {

		Product newProduct = createProductUseCase.execute(ProductMapper.toDomain(request));

		Map<String, Object> data = Map.of("message", "Produto criado com sucesso.", "product",
				ProductMapper.toProductResponse(newProduct));

		return ResponseEntity.status(HttpStatus.CREATED).body(Map.of("data", data));
	}

	@GetMapping("/list")
	@PreAuthorize("hasAnyRole('ADMIN', 'FUNCIONARIO')")
	public ResponseEntity<Map<String, Object>> list(@RequestParam(required = false) String name) {

		List<Product> products;

		if (name != null) {
			products = findProductByNameUseCase.execute(name);
		} else {
			products = listAllProductsUseCase.execute();
		}

		return ResponseEntity.ok(Map.of("data", ProductMapper.toProductResponseList(products)));
	}

	@GetMapping("/{id}")
	@PreAuthorize("hasAnyRole('ADMIN', 'FUNCIONARIO')")
	public ResponseEntity<Map<String, Object>> findById(@PathVariable UUID id) {

		Product foundProduct = findProductByIdUseCase.execute(id);

		Map<String, Object> data = Map.of("message", "Produto encontrado com sucesso.", "product",
				ProductMapper.toProductResponse(foundProduct));

		return ResponseEntity.ok(Map.of("data", data));
	}

	@PutMapping("/update/{id}")
	@PreAuthorize("hasAnyRole('ADMIN', 'FUNCIONARIO')")
	public ResponseEntity<Map<String, Object>> update(@PathVariable UUID id,
			@Valid @RequestBody ProductUpdateRequest request) {

		Product newProduct = updateProductUseCase.execute(id, ProductMapper.toDomain(request));

		Map<String, Object> data = Map.of("message", "Produto alterado com sucesso.", "product",
				ProductMapper.toProductResponse(newProduct));

		return ResponseEntity.status(HttpStatus.OK).body(Map.of("data", data));
	}

	@DeleteMapping("/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Map<String, Object>> delete(@PathVariable UUID id) {
		deleteProductUseCase.execute(id);

		Map<String, Object> data = Map.of("message", "Produto deletado com sucesso.");

		return ResponseEntity.ok(Map.of("data", data));

	}
}
