package io.github.com.salesse.MiniMarket.infrastructure.gateways;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import io.github.com.salesse.MiniMarket.core.entities.Store;
import io.github.com.salesse.MiniMarket.infrastructure.persistence.StoreEntity;
import io.github.com.salesse.MiniMarket.infrastructure.repositorys.StoreRepository;
import io.github.com.salesse.MiniMarket.infrastructure.gateway.StoreRepositoryGateway;
import io.github.com.salesse.MiniMarket.infrastructure.mappers.StoreEntityMapper;

/*
 * Testar Repositories, Jpa, Queries, mapeamento de entity para dominio
 * Queries customizadas
 * Filtros
 * 
 * Testes método AAA -> Arrange, Act, Assert
 */

@DataJpaTest
@ActiveProfiles("test")
class StoresRepositoryGatewayTest {

	@Autowired
	private StoreRepositoryGateway gateway;

	@Autowired
	private StoreRepository repository;

	@Test
	void shouldSoftDeleteStore() {
		// Arrange
		Store store = new Store(UUID.randomUUID(), "Loja Teste", "12.345.678/0001-99", "Rua A", "11999999999",
				LocalDateTime.now(), null, true);

		StoreEntity saved = repository.save(StoreEntityMapper.toEntity(store));

		// Act
		Store found = gateway.findById(saved.getId());
		found.deactivate();
		gateway.update(found.getId(), found);

		// Assert
		StoreEntity deleted = repository.findById(saved.getId()).get();
		assertFalse(deleted.isActive());
		assertNotNull(deleted.getDeletedAt());
	}

	@Test
	void shouldUpdateStoreData() {
		// Arrange
		Store store = new Store(UUID.randomUUID(), "Minha Loja", "11.782.333/0001-36", "Rua Central", "11999999999",
				LocalDateTime.now(), null, true);

		StoreEntity saved = repository.save(StoreEntityMapper.toEntity(store));

		// Act
		Store found = gateway.findById(saved.getId());
		found.setName("Loja Atualizada");
		found.setAddress("Rua B");

		gateway.update(found.getId(), found);

		// Assert
		StoreEntity updated = repository.findById(saved.getId()).get();
		assertEquals("Loja Atualizada", updated.getName());
		assertEquals("Rua B", updated.getAddress());
	}
}