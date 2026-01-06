package io.github.com.salesse.MiniMarket.infrastructure.mappers;

import java.util.List;

import io.github.com.salesse.MiniMarket.core.entities.Store;
import io.github.com.salesse.MiniMarket.infrastructure.dtos.requests.StoreRequest;
import io.github.com.salesse.MiniMarket.infrastructure.dtos.requests.StoreUpdateRequest;
import io.github.com.salesse.MiniMarket.infrastructure.dtos.responses.StoreResponse;
import lombok.experimental.UtilityClass;

@UtilityClass
public class StoreMapper {

	public static Store toDomain(StoreRequest request) {
		return new Store(null, request.getName(), request.getCnpj(), request.getAddress(), request.getPhone(), null,
				null, true);
	}

	public static Store toDomain(StoreUpdateRequest request) {
		return new Store(null, request.getName(), null, // CNPJ NÃO ALTERA
				request.getAddress(), request.getPhone(), null, null, true);
	}

	public static StoreResponse toStoreResponse(Store s) {
		return new StoreResponse(s.getId(), s.getName(), s.getCnpj(), s.getAddress(), s.getPhone());
	}
	
	public static List<StoreResponse> toStoreResponseList(List<Store> stores) {
		return stores.stream().map(StoreMapper::toStoreResponse).toList();
	}
}