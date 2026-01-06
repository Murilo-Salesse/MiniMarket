package io.github.com.salesse.MiniMarket.core.usecase.store;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;
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

import io.github.com.salesse.MiniMarket.core.entities.Stores;
import io.github.com.salesse.MiniMarket.core.gateways.StoreGateway;
import io.github.com.salesse.MiniMarket.core.usecases.stores.FindStoreByIdUseCaseImpl;

@ExtendWith(MockitoExtension.class)
public class FindStoreByIdUseCaseTest {

	@Mock
	private StoreGateway storeGateway;

	@InjectMocks
	private FindStoreByIdUseCaseImpl findStoreByIdUseCase;

	@Test
	@Description("Buscar lojas pelo nome")
	void shouldFindStoreByIdSuccessfully() {
		// Arrange
		Stores store = new Stores(UUID.randomUUID(), "Minha Loja", "12.345.678/0001-99", "Rua Central", "11999999999",
				LocalDateTime.now(), null, true);

		when(storeGateway.findById(store.getId())).thenReturn(store);

		// Act
		Stores result = findStoreByIdUseCase.execute(store.getId());

		// Assert
		assertNotNull(result);
		assertEquals(store.getId(), result.getId());
		assertEquals("Minha Loja", result.getName());

		verify(storeGateway, times(1)).findById(store.getId());
	}
}
