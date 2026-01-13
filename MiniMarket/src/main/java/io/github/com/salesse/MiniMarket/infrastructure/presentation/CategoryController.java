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

import io.github.com.salesse.MiniMarket.core.entities.Category;
import io.github.com.salesse.MiniMarket.core.usecases.categories.CreateCategoryUseCase;
import io.github.com.salesse.MiniMarket.core.usecases.categories.DeleteCategorieByIdUseCase;
import io.github.com.salesse.MiniMarket.core.usecases.categories.FindCategoryByDescUseCase;
import io.github.com.salesse.MiniMarket.core.usecases.categories.FindCategoryByIdUseCase;
import io.github.com.salesse.MiniMarket.core.usecases.categories.ListAllCategoriesUseCase;
import io.github.com.salesse.MiniMarket.core.usecases.categories.UpdateCategorieUseCase;
import io.github.com.salesse.MiniMarket.infrastructure.dtos.requests.CategoryRequest;
import io.github.com.salesse.MiniMarket.infrastructure.dtos.requests.CategoryUpdateRequest;
import io.github.com.salesse.MiniMarket.infrastructure.mappers.CategoryMapper;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

	private final CreateCategoryUseCase createCategoryUseCase;
	private final FindCategoryByIdUseCase findCategoryByIdUseCase;
	private final ListAllCategoriesUseCase listAllCategoriesUseCase;
	private final FindCategoryByDescUseCase findCategoryByDescUseCase;
	private final UpdateCategorieUseCase updateCategorieUseCase;
	private final DeleteCategorieByIdUseCase deleteCategorieByIdUseCase;

	public CategoryController(CreateCategoryUseCase createCategoryUseCase,
			FindCategoryByIdUseCase findCategoryByIdUseCase, ListAllCategoriesUseCase listAllCategoriesUseCase,
			FindCategoryByDescUseCase findCategoryByDescUseCase, DeleteCategorieByIdUseCase deleteCategorieByIdUseCase,
			UpdateCategorieUseCase updateCategorieUseCase) {
		super();
		this.createCategoryUseCase = createCategoryUseCase;
		this.findCategoryByIdUseCase = findCategoryByIdUseCase;
		this.listAllCategoriesUseCase = listAllCategoriesUseCase;
		this.findCategoryByDescUseCase = findCategoryByDescUseCase;
		this.updateCategorieUseCase = updateCategorieUseCase;
		this.deleteCategorieByIdUseCase = deleteCategorieByIdUseCase;
	}

	@PostMapping("/create")
	@PreAuthorize("hasAnyRole('ADMIN', 'FUNCIONARIO')")
	public ResponseEntity<Map<String, Object>> createCategory(@Valid @RequestBody CategoryRequest request) {

		Category newCategory = createCategoryUseCase.execute(CategoryMapper.toDomain(request));

		Map<String, Object> data = Map.of("message", "Categoria criada com sucesso.", "category",
				CategoryMapper.toCategoryResponse(newCategory));

		return ResponseEntity.status(HttpStatus.CREATED).body(Map.of("data", data));
	}

	@GetMapping("/{id}")
	@PreAuthorize("hasAnyRole('ADMIN', 'FUNCIONARIO')")
	public ResponseEntity<Map<String, Object>> findCategoryById(@PathVariable UUID id) {

		Category foundedCategory = findCategoryByIdUseCase.execute(id);

		Map<String, Object> data = Map.of("message", "Categoria encontrada com sucesso.", "category",
				CategoryMapper.toCategoryResponse(foundedCategory));

		return ResponseEntity.status(HttpStatus.CREATED).body(Map.of("data", data));
	}

	@GetMapping("/list")
	@PreAuthorize("hasAnyRole('ADMIN', 'FUNCIONARIO')")
	public ResponseEntity<Map<String, Object>> listAll(@RequestParam(required = false) String desc) {

		List<Category> category;

		if (desc != null) {
			category = findCategoryByDescUseCase.execute(desc);
		} else {
			category = listAllCategoriesUseCase.execute();
		}

		return ResponseEntity.ok(Map.of("data", CategoryMapper.toCategoryResponseList(category)));
	}

	@PutMapping("/update/{id}")
	@PreAuthorize("hasAnyRole('ADMIN', 'FUNCIONARIO')")
	public ResponseEntity<Map<String, Object>> update(@PathVariable UUID id,
			@Valid @RequestBody CategoryUpdateRequest request) {

		Category newCategory = updateCategorieUseCase.execute(id, CategoryMapper.toDomain(request));

		Map<String, Object> data = Map.of("message", "Categoria alterada com sucesso.", "category",
				CategoryMapper.toCategoryResponse(newCategory));

		return ResponseEntity.status(HttpStatus.OK).body(Map.of("data", data));
	}

	@DeleteMapping("/{id}")
	@PreAuthorize("hasAnyRole('ADMIN', 'FUNCIONARIO')")
	public ResponseEntity<Map<String, Object>> delete(@PathVariable UUID id) {
		deleteCategorieByIdUseCase.execute(id);

		Map<String, Object> data = Map.of("message", "Categoria deletada com sucesso.");

		return ResponseEntity.ok(Map.of("data", data));

	}
}
