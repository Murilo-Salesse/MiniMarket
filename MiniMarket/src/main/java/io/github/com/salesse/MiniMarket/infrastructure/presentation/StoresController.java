package io.github.com.salesse.MiniMarket.infrastructure.presentation;

import java.util.Map;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.com.salesse.MiniMarket.core.entities.Stores;
import io.github.com.salesse.MiniMarket.core.usecases.stores.CreateStoreUseCase;
import io.github.com.salesse.MiniMarket.core.usecases.stores.FindStoreByIdUseCase;
import io.github.com.salesse.MiniMarket.infrastructure.dtos.requests.StoreRequest;
import io.github.com.salesse.MiniMarket.infrastructure.mappers.StoresMapper;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/stores")
public class StoresController {

	private final CreateStoreUseCase createStoreUseCase;
	private final FindStoreByIdUseCase findStoreByIdUseCase;

	public StoresController(CreateStoreUseCase createStoreUseCase, FindStoreByIdUseCase findStoreByIdUseCase) {
		super();
		this.createStoreUseCase = createStoreUseCase;
		this.findStoreByIdUseCase = findStoreByIdUseCase;
	}

	@PostMapping("/create")
	public ResponseEntity<Map<String, Object>> createStore(@Valid @RequestBody StoreRequest request) {

		Stores newStore = createStoreUseCase.execute(StoresMapper.toDomain(request));

		Map<String, Object> data = Map.of("message", "Loja criada com sucesso.", "store",
				StoresMapper.toStoreResponse(newStore));

		return ResponseEntity.status(HttpStatus.CREATED).body(Map.of("data", data));
	}

	@GetMapping("/{id}")
	public ResponseEntity<Map<String, Object>> findStoreById(@PathVariable("id") UUID id) {

		Stores foundedStore = findStoreByIdUseCase.execute(id);

		Map<String, Object> data = Map.of("message", "Loja encontrada com sucesso.", "store",
				StoresMapper.toStoreResponse(foundedStore));

		return ResponseEntity.ok(Map.of("data", data));
	}
}
