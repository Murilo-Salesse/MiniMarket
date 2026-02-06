package io.github.com.salesse.MiniMarket.infrastructure.presentation;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.com.salesse.MiniMarket.core.entities.Stock;
import io.github.com.salesse.MiniMarket.core.usecases.stock.CreateStockUseCase;
import io.github.com.salesse.MiniMarket.core.usecases.stock.ListAllStocksUseCase;
import io.github.com.salesse.MiniMarket.infrastructure.dtos.requests.StockRequest;
import io.github.com.salesse.MiniMarket.infrastructure.mappers.StockMapper;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/stocks")
public class StockController {

	private final CreateStockUseCase createStockUseCase;
	private final ListAllStocksUseCase listAllStocksUseCase;

	public StockController(CreateStockUseCase createStockUseCase, ListAllStocksUseCase listAllStocksUseCase) {
		super();
		this.createStockUseCase = createStockUseCase;
		this.listAllStocksUseCase = listAllStocksUseCase;
	}

	@PostMapping("/create")
	@PreAuthorize("hasAnyRole('ADMIN', 'FUNCIONARIO')")
	public ResponseEntity<Map<String, Object>> createStock(@Valid @RequestBody StockRequest request) {

		Stock newStock = createStockUseCase.execute(StockMapper.toDomain(request));

		Map<String, Object> data = Map.of("message", "Estoque criado com sucesso.", "stock",
				StockMapper.toStockResponse(newStock));

		return ResponseEntity.status(HttpStatus.CREATED).body(Map.of("data", data));
	}

	@GetMapping("/list")
	@PreAuthorize("hasAnyRole('ADMIN', 'FUNCIONARIO')")
	public ResponseEntity<Map<String, Object>> list() {

		List<Stock> stocks = listAllStocksUseCase.execute();
		;
		return ResponseEntity.ok(Map.of("data", StockMapper.toStockResponseList(stocks)));
	}
}
