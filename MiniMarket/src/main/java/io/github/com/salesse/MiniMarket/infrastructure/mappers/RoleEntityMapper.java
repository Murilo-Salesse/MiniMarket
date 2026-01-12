package io.github.com.salesse.MiniMarket.infrastructure.mappers;

import io.github.com.salesse.MiniMarket.core.entities.Role;
import io.github.com.salesse.MiniMarket.infrastructure.persistence.RoleEntity;
import lombok.experimental.UtilityClass;

@UtilityClass
public class RoleEntityMapper {

	public static Role toDomain(RoleEntity entity) {
		return new Role(entity.getId(), entity.getName());
	}

	public static RoleEntity toEntity(Role role) {
		RoleEntity entity = new RoleEntity();
		entity.setId(role.getId());
		entity.setName(role.getName());
		return entity;
	}
}
