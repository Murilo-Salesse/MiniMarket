package io.github.com.salesse.MiniMarket.core.usecases.stock;

import io.github.com.salesse.MiniMarket.core.entities.Stock;

public interface CreateStockUseCase {

	Stock execute(Stock stock);

}
