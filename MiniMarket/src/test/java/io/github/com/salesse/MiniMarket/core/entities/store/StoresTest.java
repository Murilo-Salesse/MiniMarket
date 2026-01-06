package io.github.com.salesse.MiniMarket.core.entities.store;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.UUID;

import org.junit.jupiter.api.Test;

import io.github.com.salesse.MiniMarket.core.entities.Store;
import io.github.com.salesse.MiniMarket.core.exceptions.BusinessRuleException;

/*
 * Regras de negócio internas
 * Comportamento do domínio
 * Sem Mock
 * Sem Gateway
 * Sem Spring
 * Sem UseCase
 * 
 * Testes método AAA -> Arrange, Act, Assert
 */
class StoresTest {

	@Test
	void shouldDeactivateStoreSuccessfully() {
		// Arrange
		Store store = new Store(UUID.randomUUID(), "Minha Loja", "12.345.678/0001-99", "Rua Central", "11999999999",
				LocalDateTime.now(), null, true);

		// Act
		store.deactivate();

		// Assert
		assertFalse(store.isActive());
		assertNotNull(store.getDeletedAt());
	}

	@Test
	void shouldThrowExceptionWhenDeactivatingInactiveStore() {
		Store store = new Store();
		store.setActive(false);

		assertThrows(BusinessRuleException.class, store::deactivate);
	}
}