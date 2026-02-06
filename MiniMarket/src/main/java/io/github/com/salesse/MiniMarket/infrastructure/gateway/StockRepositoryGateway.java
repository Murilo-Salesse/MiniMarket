package io.github.com.salesse.MiniMarket.infrastructure.gateway;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import io.github.com.salesse.MiniMarket.core.entities.Stock;
import io.github.com.salesse.MiniMarket.core.gateways.StockGateway;
import io.github.com.salesse.MiniMarket.infrastructure.mappers.StockEntityMapper;
import io.github.com.salesse.MiniMarket.infrastructure.repositorys.StockRepository;

@Component
public class StockRepositoryGateway implements StockGateway {

	private final StockRepository stockRepository;

	public StockRepositoryGateway(StockRepository stockRepository) {
		super();
		this.stockRepository = stockRepository;
	}

	@Override
	public Stock create(Stock stock) {
		return StockEntityMapper.toDomain(stockRepository.save(StockEntityMapper.toEntity(stock)));
	}

	@Override
	public List<Stock> listAll() {
		return stockRepository.findAll().stream().map(StockEntityMapper::toDomain).collect(Collectors.toList());
	}


}
