package io.github.com.salesse.MiniMarket.infrastructure.mappers;

import io.github.com.salesse.MiniMarket.core.entities.User;
import io.github.com.salesse.MiniMarket.infrastructure.persistence.UserEntity;
import lombok.experimental.UtilityClass;

@UtilityClass
public class UserEntityMapper {

	// Converte de UserEntity para Dominio puro
	public static User toDomain(UserEntity entity) {
		return new User(entity.getId(), entity.getStoreId(), entity.getName(), entity.getEmail(), entity.getPhone(),
				entity.getPassword(), entity.isActive(), entity.getCreatedAt(), entity.getDeletedAt());
	}

	// Converte de Entidade do banco para UserDto (saida)
	public static UserEntity toEntity(User user) {
		UserEntity entity = new UserEntity();
		entity.setId(user.getId());
		entity.setStoreId(user.getStoreId());
		entity.setName(user.getName());
		entity.setEmail(user.getEmail());
		entity.setPhone(user.getPhone());
		entity.setPassword(user.getPassword());
		entity.setActive(user.getActive());
		entity.setCreatedAt(user.getCreatedAt());
		entity.setDeletedAt(user.getDeletedAt());
		return entity;
	}
}
