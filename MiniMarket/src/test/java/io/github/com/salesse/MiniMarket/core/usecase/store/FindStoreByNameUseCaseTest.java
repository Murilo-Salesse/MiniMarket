package io.github.com.salesse.MiniMarket.core.usecase.store;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.context.annotation.Description;

import io.github.com.salesse.MiniMarket.core.entities.Store;
import io.github.com.salesse.MiniMarket.core.gateways.StoreGateway;
import io.github.com.salesse.MiniMarket.core.usecases.stores.FindStoreByNameUseCaseImpl;

@ExtendWith(MockitoExtension.class)
public class FindStoreByNameUseCaseTest {

	@Mock
	private StoreGateway storeGateway;

	@InjectMocks
	private FindStoreByNameUseCaseImpl findStoreByNameUseCase;

	@Test
	@Description("Buscar lojas pelo nome")
	void shouldFindStoreByNameSuccessfully() {
		// Arrange
		Store storeOne = new Store(UUID.randomUUID(), "Minha Loja", "12.345.678/0001-99", "Rua Central",
				"11999999999", LocalDateTime.now(), null, true);

		List<Store> stores = List.of(storeOne);

		when(storeGateway.findByName("Minha Loja")).thenReturn(stores);

		// Act
		List<Store> result = findStoreByNameUseCase.execute("Minha Loja");

		// Assert
		assertNotNull(result);
		assertEquals(1, result.size());
		assertEquals("Minha Loja", result.get(0).getName());

		verify(storeGateway, times(1)).findByName("Minha Loja");
	}
}
