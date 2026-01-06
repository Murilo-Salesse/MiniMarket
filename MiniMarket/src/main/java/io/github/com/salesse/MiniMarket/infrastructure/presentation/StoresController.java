package io.github.com.salesse.MiniMarket.infrastructure.presentation;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.github.com.salesse.MiniMarket.core.entities.Stores;
import io.github.com.salesse.MiniMarket.core.usecases.stores.CreateStoreUseCase;
import io.github.com.salesse.MiniMarket.core.usecases.stores.DeleteStoreUseCase;
import io.github.com.salesse.MiniMarket.core.usecases.stores.FindStoreByIdUseCase;
import io.github.com.salesse.MiniMarket.core.usecases.stores.FindStoreByNameUseCase;
import io.github.com.salesse.MiniMarket.core.usecases.stores.ListAllStoresUseCase;
import io.github.com.salesse.MiniMarket.core.usecases.stores.UpdateStoreUseCase;
import io.github.com.salesse.MiniMarket.infrastructure.dtos.requests.StoreRequest;
import io.github.com.salesse.MiniMarket.infrastructure.dtos.requests.StoreUpdateRequest;
import io.github.com.salesse.MiniMarket.infrastructure.mappers.StoresMapper;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/stores")
public class StoresController {

	private final CreateStoreUseCase createStoreUseCase;
	private final FindStoreByIdUseCase findStoreByIdUseCase;
	private final DeleteStoreUseCase deleteStoreUseCase;
	private final UpdateStoreUseCase updateStoreUseCase;
	private final ListAllStoresUseCase listAllStoresUseCase;
	private final FindStoreByNameUseCase findStoreByNameUseCase;

	public StoresController(CreateStoreUseCase createStoreUseCase, FindStoreByIdUseCase findStoreByIdUseCase,
			DeleteStoreUseCase deleteStoreUseCase, UpdateStoreUseCase updateStoreUseCase,
			ListAllStoresUseCase listAllStoresUseCase, FindStoreByNameUseCase findStoreByNameUseCase) {
		super();
		this.createStoreUseCase = createStoreUseCase;
		this.findStoreByIdUseCase = findStoreByIdUseCase;
		this.deleteStoreUseCase = deleteStoreUseCase;
		this.updateStoreUseCase = updateStoreUseCase;
		this.listAllStoresUseCase = listAllStoresUseCase;
		this.findStoreByNameUseCase = findStoreByNameUseCase;
	}

	@PostMapping("/create")
	public ResponseEntity<Map<String, Object>> createStore(@Valid @RequestBody StoreRequest request) {

		Stores newStore = createStoreUseCase.execute(StoresMapper.toDomain(request));

		Map<String, Object> data = Map.of("message", "Loja criada com sucesso.", "store",
				StoresMapper.toStoreResponse(newStore));

		return ResponseEntity.status(HttpStatus.CREATED).body(Map.of("data", data));
	}

	@GetMapping("/{id}")
	public ResponseEntity<Map<String, Object>> findStoreById(@PathVariable UUID id) {

		Stores foundedStore = findStoreByIdUseCase.execute(id);

		Map<String, Object> data = Map.of("message", "Loja encontrada com sucesso.", "store",
				StoresMapper.toStoreResponse(foundedStore));

		return ResponseEntity.ok(Map.of("data", data));
	}

	@GetMapping("/list")
	public ResponseEntity<Map<String, Object>> list(@RequestParam(required = false) String name) {

		List<Stores> stores;

		if (name != null) {
			stores = findStoreByNameUseCase.execute(name);
		} else {
			stores = listAllStoresUseCase.execute();
		}

		return ResponseEntity.ok(Map.of("data", StoresMapper.toStoreResponseList(stores)));
	}

	@GetMapping("/all")
	public ResponseEntity<Map<String, Object>> list() {

		List<Stores> list = listAllStoresUseCase.execute();

		Map<String, Object> data = Map.of("message", "Loja(s) encontrada(s) com sucesso.", "stores",
				StoresMapper.toStoreResponseList(list));

		return ResponseEntity.ok(Map.of("data", data));
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<Map<String, Object>> update(@PathVariable UUID id,
			@Valid @RequestBody StoreUpdateRequest request) {

		Stores newStore = updateStoreUseCase.execute(id, StoresMapper.toDomain(request));

		Map<String, Object> data = Map.of("message", "Loja alterada com sucesso.", "store",
				StoresMapper.toStoreResponse(newStore));

		return ResponseEntity.status(HttpStatus.OK).body(Map.of("data", data));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Map<String, Object>> delete(@PathVariable UUID id) {
		deleteStoreUseCase.execute(id);

		Map<String, Object> data = Map.of("message", "Loja deletada com sucesso.");

		return ResponseEntity.ok(Map.of("data", data));

	}
}
