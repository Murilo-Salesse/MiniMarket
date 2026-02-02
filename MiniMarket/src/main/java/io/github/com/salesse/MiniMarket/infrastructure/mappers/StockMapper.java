package io.github.com.salesse.MiniMarket.infrastructure.mappers;

import java.util.List;

import io.github.com.salesse.MiniMarket.core.entities.Stock;
import io.github.com.salesse.MiniMarket.infrastructure.dtos.requests.StockRequest;
import io.github.com.salesse.MiniMarket.infrastructure.dtos.responses.StockResponse;
import lombok.experimental.UtilityClass;

@UtilityClass
public class StockMapper {

	// Transforma request em entidade pura
	public static Stock toDomain(StockRequest request) {

		return new Stock(null, request.getStoreId(), request.getProductId(), request.getQuantity(),
				request.getMinQuantity());
	}

	// Transforma entidade pura em response
	public static StockResponse toStockResponse(Stock s) {
		return new StockResponse(s.getId(), s.getStoreId(), s.getProductId(), s.getQuantity(), s.getMinQuantity());
	}

	public static List<StockResponse> toStockResponseList(List<Stock> stocks) {
		return stocks.stream().map(StockMapper::toStockResponse).toList();
	}
}
