package io.github.com.salesse.MiniMarket.core.usecase.store;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.context.annotation.Description;

import io.github.com.salesse.MiniMarket.core.entities.Store;
import io.github.com.salesse.MiniMarket.core.gateways.StoreGateway;
import io.github.com.salesse.MiniMarket.core.usecases.stores.CreateStoreUseCaseImpl;

/*
 * Testa se o UseCase chama o gateway corretamente
 * Testa a regra do caso de uso
 * Não testa JPA, SQL, Repository, Hibernate
 * Rápido
 * Usa Mockito
 * Isola regra de negócio
 * */
@ExtendWith(MockitoExtension.class)
public class CreateStoreUseCaseTest {

	@Mock
	private StoreGateway storeGateway;

	@InjectMocks
	private CreateStoreUseCaseImpl createStoreUseCase;

	@Test
	@Description("Cria uma loja")
	void shouldCreateStoreSuccessfully() {
		// Arrange
		Store store = new Store(UUID.randomUUID(), "Minha Loja", "12.345.678/0001-99", "Rua Central", "11999999999",
				LocalDateTime.now(), null, true);
		
		
		when(storeGateway.create(any(Store.class))).thenReturn(store);

		// Act
		Store result = createStoreUseCase.execute(store);

		// Assert
		assertNotNull(result);
		assertEquals("Minha Loja", result.getName());

		verify(storeGateway).create(store);
	}
}
