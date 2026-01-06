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
import io.github.com.salesse.MiniMarket.core.usecases.stores.UpdateStoreUseCaseImpl;

@ExtendWith(MockitoExtension.class)
class UpdateStoreUseCaseTest {

	@Mock
	private StoreGateway storeGateway;

	@InjectMocks
	private UpdateStoreUseCaseImpl updateStoreUseCase;

	@Test
	@Description("Atualizar loja com sucesso")
	void shouldUpdateStoreSuccessfully() {
		// Arrange
		UUID id = UUID.randomUUID();

		Store existingStore = new Store(id, "Minha Loja", "12.345.678/0001-99", "Rua Central", "11999999999",
				LocalDateTime.now(), null, true);

		Store updatedStore = new Store(id, "Minha Loja ATT", "12.345.678/0001-99", "Rua Central ATT", "11999999999",
				existingStore.getCreatedAt(), null, true);

		when(storeGateway.findById(id)).thenReturn(existingStore);
		when(storeGateway.update(id, updatedStore)).thenReturn(updatedStore);

		// Act
		Store result = updateStoreUseCase.execute(id, updatedStore);

		// Assert
		assertNotNull(result);
		assertEquals("Minha Loja ATT", result.getName());
		assertEquals("Rua Central ATT", result.getAddress());

		verify(storeGateway, times(1)).findById(id);
		verify(storeGateway, times(1)).update(id, updatedStore);
	}
}
