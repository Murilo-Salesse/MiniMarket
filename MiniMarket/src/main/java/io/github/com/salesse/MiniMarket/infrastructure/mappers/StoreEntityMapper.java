package io.github.com.salesse.MiniMarket.infrastructure.mappers;

import io.github.com.salesse.MiniMarket.core.entities.Store;
import io.github.com.salesse.MiniMarket.infrastructure.persistence.StoreEntity;
import lombok.experimental.UtilityClass;

@UtilityClass
public class StoreEntityMapper {

	// Converte de RequestDto para Entidade do banco
	public static Store toDomain(StoreEntity entity) {
		return new Store(entity.getId(), entity.getName(), entity.getCnpj(), entity.getAddress(), entity.getPhone(),
				entity.getCreatedAt(), entity.getDeletedAt(), entity.isActive());
	}

	// Converte de Entidade do banco para RequestDto (saida)
	public static StoreEntity toEntity(Store store) {
		StoreEntity entity = new StoreEntity();
		entity.setId(store.getId());
		entity.setName(store.getName());
		entity.setCnpj(store.getCnpj());
		entity.setAddress(store.getAddress());
		entity.setPhone(store.getPhone());
		entity.setActive(store.isActive());
		entity.setDeletedAt(store.getDeletedAt());
		return entity;
	}
}
