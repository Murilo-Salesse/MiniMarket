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
import io.github.com.salesse.MiniMarket.core.usecases.stores.ListAllStoresUseCaseImpl;

@ExtendWith(MockitoExtension.class)
public class ListAllStoresUseCaseTest {

	@Mock
	private StoreGateway storeGateway;

	@InjectMocks
	private ListAllStoresUseCaseImpl listAllStoresUseCase;

	@Test
	@Description("Listar todas as lojas")
	void shouldListAllStoresSuccessfully() {
		// Arrange
		Store storeOne = new Store(UUID.randomUUID(), "Minha Loja", "12.345.678/0001-99", "Rua Central",
				"11999999999", LocalDateTime.now(), null, true);

		Store storeTwo = new Store(UUID.randomUUID(), "Minha Loja Dois", "13.215.438/0001-44", "Rua Central Dois",
				"11999999998", LocalDateTime.now(), null, true);

		List<Store> stores = List.of(storeOne, storeTwo);

		when(storeGateway.listAll()).thenReturn(stores);

		// Act
		List<Store> result = listAllStoresUseCase.execute();

		// Assert
		assertNotNull(result);
		assertEquals(2, result.size());
		assertEquals("Minha Loja", result.get(0).getName());
		assertEquals("Minha Loja Dois", result.get(1).getName());

		verify(storeGateway, times(1)).listAll();
	}
}
