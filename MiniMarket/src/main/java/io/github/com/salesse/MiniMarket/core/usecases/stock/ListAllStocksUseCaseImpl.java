package io.github.com.salesse.MiniMarket.core.usecases.stock;

import java.util.List;

import io.github.com.salesse.MiniMarket.core.entities.Stock;
import io.github.com.salesse.MiniMarket.core.gateways.StockGateway;

public class ListAllStocksUseCaseImpl implements ListAllStocksUseCase {

	private final StockGateway stockGateway;

	public ListAllStocksUseCaseImpl(StockGateway stockGateway) {
		super();
		this.stockGateway = stockGateway;
	}

	@Override
	public List<Stock> execute() {
		return stockGateway.listAll();
	}

}
