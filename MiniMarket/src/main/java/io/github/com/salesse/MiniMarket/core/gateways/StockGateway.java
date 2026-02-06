package io.github.com.salesse.MiniMarket.core.gateways;

import java.util.List;

import io.github.com.salesse.MiniMarket.core.entities.Stock;

public interface StockGateway {

	Stock create(Stock stock);
	List<Stock> listAll();
}
