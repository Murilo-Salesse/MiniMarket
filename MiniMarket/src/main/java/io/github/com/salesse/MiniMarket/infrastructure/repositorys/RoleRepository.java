package io.github.com.salesse.MiniMarket.infrastructure.repositorys;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.com.salesse.MiniMarket.infrastructure.persistence.RoleEntity;

public interface RoleRepository extends JpaRepository<RoleEntity, UUID>{

	Optional<RoleEntity> findByName(String name);
}
