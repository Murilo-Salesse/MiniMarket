package io.github.com.salesse.MiniMarket.infrastructure.gateways;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import io.github.com.salesse.MiniMarket.core.entities.Stores;
import io.github.com.salesse.MiniMarket.infrastructure.persistence.StoresEntity;
import io.github.com.salesse.MiniMarket.infrastructure.repositorys.StoresRepository;
import io.github.com.salesse.MiniMarket.infrastructure.gateway.StoresRepositoryGateway;
import io.github.com.salesse.MiniMarket.infrastructure.mappers.StoresEntityMapper;

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
	private StoresRepositoryGateway gateway;

	@Autowired
	private StoresRepository repository;

	@Test
	void shouldSoftDeleteStore() {
		// Arrange
		Stores store = new Stores(UUID.randomUUID(), "Loja Teste", "12.345.678/0001-99", "Rua A", "11999999999",
				LocalDateTime.now(), null, true);

		StoresEntity saved = repository.save(StoresEntityMapper.toEntity(store));

		// Act
		Stores found = gateway.findById(saved.getId());
		found.deactivate();
		gateway.update(found.getId(), found);

		// Assert
		StoresEntity deleted = repository.findById(saved.getId()).get();
		assertFalse(deleted.isActive());
		assertNotNull(deleted.getDeletedAt());
	}

	@Test
	void shouldUpdateStoreData() {
		// Arrange
		Stores store = new Stores(UUID.randomUUID(), "Minha Loja", "11.782.333/0001-36", "Rua Central", "11999999999",
				LocalDateTime.now(), null, true);

		StoresEntity saved = repository.save(StoresEntityMapper.toEntity(store));

		// Act
		Stores found = gateway.findById(saved.getId());
		found.setName("Loja Atualizada");
		found.setAddress("Rua B");

		gateway.update(found.getId(), found);

		// Assert
		StoresEntity updated = repository.findById(saved.getId()).get();
		assertEquals("Loja Atualizada", updated.getName());
		assertEquals("Rua B", updated.getAddress());
	}
}