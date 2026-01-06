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

import io.github.com.salesse.MiniMarket.core.entities.Store;
import io.github.com.salesse.MiniMarket.core.gateways.StoreGateway;
import io.github.com.salesse.MiniMarket.core.usecases.stores.DeleteStoreUseCaseImpl;

@ExtendWith(MockitoExtension.class)
class DeleteStoreUseCaseTest {

	@Mock
	private StoreGateway storeGateway;

	@InjectMocks
	private DeleteStoreUseCaseImpl deleteStoreUseCase;

	@Test
	@Description("Deve realizar soft delete da loja")
	void shouldSoftDeleteStoreSuccessfully() {
		// Arrange
		UUID storeId = UUID.randomUUID();

		Store store = new Store(storeId, "Minha Loja", "12.345.678/0001-99", "Rua Central", "11999999999",
				LocalDateTime.now(), null, true);

		when(storeGateway.findById(storeId)).thenReturn(store);

		// Act
		deleteStoreUseCase.execute(storeId);

		// Assert
		assertEquals(false, store.isActive());
		assertNotNull(store.getDeletedAt());

		verify(storeGateway, times(1)).findById(storeId);
		verify(storeGateway, times(1)).update(storeId, store);
	}
}
