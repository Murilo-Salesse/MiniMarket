package io.github.com.salesse.MiniMarket.core.usecases.stock;

import java.util.UUID;

import io.github.com.salesse.MiniMarket.core.entities.Product;
import io.github.com.salesse.MiniMarket.core.entities.Stock;
import io.github.com.salesse.MiniMarket.core.exceptions.BusinessRuleException;
import io.github.com.salesse.MiniMarket.core.gateways.ProductGateway;
import io.github.com.salesse.MiniMarket.core.gateways.StockGateway;
import io.github.com.salesse.MiniMarket.core.gateways.StoreGateway;
import io.github.com.salesse.MiniMarket.infrastructure.security.AuthenticatedUser;

public class CreateStockUseCaseImpl implements CreateStockUseCase {

	private final StockGateway stockGateway;
	private final StoreGateway storeGateway;
	private final ProductGateway productGateway;

	public CreateStockUseCaseImpl(StockGateway stockGateway, StoreGateway storeGateway, ProductGateway productGateway) {
		super();
		this.stockGateway = stockGateway;
		this.storeGateway = storeGateway;
		this.productGateway = productGateway;
	}

	@Override
	public Stock execute(Stock stock) {

		UUID storeIdFromToken = AuthenticatedUser.getStoreId();
		if (!storeGateway.existsById(storeIdFromToken)) {
			throw new BusinessRuleException("Loja não encontrada");
		}

		Product product = productGateway.findById(stock.getProductId());
		if (!product.getStoreId().equals(storeIdFromToken)) {
			throw new BusinessRuleException("Usuario não pode cadastrar estoque nesta loja");

		}

		stock.setStoreId(storeIdFromToken);
		return stockGateway.create(stock);
	}

}
