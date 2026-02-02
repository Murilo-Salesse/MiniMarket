package io.github.com.salesse.MiniMarket.core.gateways;

import io.github.com.salesse.MiniMarket.core.entities.Stock;

public interface StockGateway {

	Stock create(Stock stock);
}
