package io.github.com.salesse.MiniMarket.core.usecases.stock;

import java.util.List;

import io.github.com.salesse.MiniMarket.core.entities.Stock;

public interface ListAllStocksUseCase {

	List<Stock> execute();
}
