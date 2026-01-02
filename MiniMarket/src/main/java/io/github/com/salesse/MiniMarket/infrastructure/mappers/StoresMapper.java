package io.github.com.salesse.MiniMarket.infrastructure.mappers;

import java.util.List;

import io.github.com.salesse.MiniMarket.core.entities.Stores;
import io.github.com.salesse.MiniMarket.infrastructure.dtos.requests.StoreRequest;
import io.github.com.salesse.MiniMarket.infrastructure.dtos.requests.StoreUpdateRequest;
import io.github.com.salesse.MiniMarket.infrastructure.dtos.responses.StoreResponse;
import lombok.experimental.UtilityClass;

@UtilityClass
public class StoresMapper {

	public static Stores toDomain(StoreRequest request) {
		return new Stores(null, request.getName(), request.getCnpj(), request.getAddress(), request.getPhone(), null,
				null, true);
	}

	public static Stores toDomain(StoreUpdateRequest request) {
		return new Stores(null, request.getName(), null, // CNPJ NÃO ALTERA
				request.getAddress(), request.getPhone(), null, null, true);
	}

	public static StoreResponse toStoreResponse(Stores s) {
		return new StoreResponse(s.getId(), s.getName(), s.getCnpj(), s.getAddress(), s.getPhone());
	}
	
	public static List<StoreResponse> toStoreResponseList(List<Stores> stores) {
		return stores.stream().map(StoresMapper::toStoreResponse).toList();
	}
}