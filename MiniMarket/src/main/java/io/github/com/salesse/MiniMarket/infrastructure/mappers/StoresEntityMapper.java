package io.github.com.salesse.MiniMarket.infrastructure.mappers;

import io.github.com.salesse.MiniMarket.core.entities.Stores;
import io.github.com.salesse.MiniMarket.infrastructure.persistence.StoresEntity;
import lombok.experimental.UtilityClass;

@UtilityClass
public class StoresEntityMapper {

	// Converte de RequestDto para Entidade do banco
	public static Stores toDomain(StoresEntity entity) {
		return new Stores(entity.getId(), entity.getName(), entity.getCnpj(), entity.getAddress(), entity.getPhone(),
				entity.getCreatedAt(), entity.getDeletedAt(), entity.isActive());
	}

	// Converte de Entidade do banco para RequestDto (saida)

	public static StoresEntity toEntity(Stores store) {
		StoresEntity entity = new StoresEntity();
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
