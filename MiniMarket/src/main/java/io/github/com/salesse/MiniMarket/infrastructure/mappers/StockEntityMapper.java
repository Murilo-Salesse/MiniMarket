package io.github.com.salesse.MiniMarket.infrastructure.mappers;

import io.github.com.salesse.MiniMarket.core.entities.Stock;
import io.github.com.salesse.MiniMarket.infrastructure.persistence.StockEntity;
import lombok.experimental.UtilityClass;

@UtilityClass
public class StockEntityMapper {

	// Converte de Entity para Dominio puro
	public static Stock toDomain(StockEntity entity) {

		return new Stock(entity.getId(), entity.getStoreId(), entity.getProductId(), entity.getQuantity(),
				entity.getMinQuantity());
	}

	// Converte de Entidade do banco para Response (saida)
	public static StockEntity toEntity(Stock s) {

		StockEntity entity = new StockEntity();
		entity.setId(s.getId());
		entity.setStoreId(s.getStoreId());
		entity.setProductId(s.getProductId());
		entity.setQuantity(s.getQuantity());
		entity.setMinQuantity(s.getMinQuantity());

		return entity;
	}
}
