package io.github.com.salesse.MiniMarket.infrastructure.presentation;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.context.annotation.Description;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import tools.jackson.databind.json.JsonMapper;

import io.github.com.salesse.MiniMarket.core.entities.Stores;
import io.github.com.salesse.MiniMarket.core.usecases.stores.CreateStoreUseCase;
import io.github.com.salesse.MiniMarket.core.usecases.stores.DeleteStoreUseCase;
import io.github.com.salesse.MiniMarket.core.usecases.stores.FindStoreByIdUseCase;
import io.github.com.salesse.MiniMarket.core.usecases.stores.FindStoreByNameUseCase;
import io.github.com.salesse.MiniMarket.core.usecases.stores.ListAllStoresUseCase;
import io.github.com.salesse.MiniMarket.core.usecases.stores.UpdateStoreUseCase;
import io.github.com.salesse.MiniMarket.infrastructure.dtos.requests.StoreRequest;

@WebMvcTest(StoresController.class)
class StoresControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockitoBean
	private CreateStoreUseCase createStoreUseCase;

	@MockitoBean
	private ListAllStoresUseCase listAllStoresUseCase;

	@MockitoBean
	private FindStoreByIdUseCase findStoreByIdUseCase;

	@MockitoBean
	private DeleteStoreUseCase deleteStoreUseCase;

	@MockitoBean
	private UpdateStoreUseCase updateStoreUseCase;

	@MockitoBean
	private FindStoreByNameUseCase findStoreByNameUseCase;

	@Autowired
	private JsonMapper objectMapper;

	@Test
	@Description("Deve criar uma loja")
	void shouldCreateStoreSuccessfully() throws Exception {
		// Arrange
		StoreRequest request = new StoreRequest();
		request.setName("Minha Loja");
		request.setCnpj("36.291.365/0001-60");
		request.setAddress("Rua Central");
		request.setPhone("11999999999");

		Stores store = new Stores(UUID.randomUUID(), "Minha Loja", "36.291.365/0001-60", "Rua Central", "11999999999",
				LocalDateTime.now(), null, true);

		when(createStoreUseCase.execute(any())).thenReturn(store);

		// Act & Assert
		mockMvc.perform(post("/api/stores/create").contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(request))).andExpect(status().isCreated())
				.andExpect(jsonPath("$.data.store.name").value("Minha Loja"));
	}

	@Test
	@Description("Deve listar todas as lojas")
	void shouldListAllStoresSuccessfully() throws Exception {
		// Arrange
		Stores store = new Stores(UUID.randomUUID(), "Minha Loja", "11.782.333/0001-36", "Rua Central", "11999999999",
				LocalDateTime.now(), null, true);

		when(listAllStoresUseCase.execute()).thenReturn(List.of(store));

		// Act & Assert
		mockMvc.perform(get("/api/stores/all").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(jsonPath("$.data.stores[0].name").value("Minha Loja"));

	}

	@Test
	@Description("Deve listar loja por nome")
	void shouldListStoreByNameSuccessfully() throws Exception {
		// Arrange
		Stores store = new Stores(UUID.randomUUID(), "Minha Loja", "11.782.333/0001-36", "Rua Central", "11999999999",
				LocalDateTime.now(), null, true);

		when(findStoreByNameUseCase.execute(store.getName())).thenReturn(List.of(store));

		// Act & Assert
		mockMvc.perform(get("/api/stores/list?name=" + store.getName()).contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andExpect(jsonPath("$.data[0].name").value("Minha Loja"));

	}

	@Test
	@Description("Deve listar loja por ID")
	void shouldListStoreByIdSuccessfully() throws Exception {
		// Arrange
		Stores store = new Stores(UUID.randomUUID(), "Minha Loja", "11.782.333/0001-36", "Rua Central", "11999999999",
				LocalDateTime.now(), null, true);

		when(findStoreByIdUseCase.execute(store.getId())).thenReturn(store);

		// Act & Assert
		mockMvc.perform(get("/api/stores/" + store.getId()).contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andExpect(jsonPath("$.data.store.name").value("Minha Loja"));

	}

	@Test
	@Description("Deve atualizar uma loja")
	void shouldUpdateStoreSuccessfully() throws Exception {
		// Arrange
		UUID storeId = UUID.randomUUID();

		StoreRequest request = new StoreRequest();
		request.setName("Minha Loja Atualizada");
		request.setAddress("Rua Central Atualizada");
		request.setPhone("11988887777");

		Stores updatedStore = new Stores(storeId, "Minha Loja Atualizada", "11.782.333/0001-36",
				"Rua Central Atualizada", "11988887777", LocalDateTime.now(), null, true);

		when(updateStoreUseCase.execute(any(UUID.class), any(Stores.class))).thenReturn(updatedStore);

		// Act & Assert
		mockMvc.perform(put("/api/stores/update/" + storeId).contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(request))).andExpect(status().isOk())
				.andExpect(jsonPath("$.data.store.name").value("Minha Loja Atualizada"))
				.andExpect(jsonPath("$.data.message").value("Loja alterada com sucesso."));
	}

	@Test
	@Description("Deve deletar loja por ID")
	void shouldDeleteStoreByIdSuccessfully() throws Exception {
		// Arrange
		Stores store = new Stores(UUID.randomUUID(), "Minha Loja", "11.782.333/0001-36", "Rua Central", "11999999999",
				LocalDateTime.now(), null, true);

		doNothing().when(deleteStoreUseCase).execute(store.getId());

		// Act & Assert
		mockMvc.perform(delete("/api/stores/" + store.getId()).contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andExpect(jsonPath("$.data.message").value("Loja deletada com sucesso."));

	}
}