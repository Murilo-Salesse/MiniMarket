package io.github.com.salesse.MiniMarket.core.usecases.stores;

import java.util.UUID;

import io.github.com.salesse.MiniMarket.core.entities.Store;
import io.github.com.salesse.MiniMarket.core.gateways.StoreGateway;

public class FindStoreByIdUseCaseImpl implements FindStoreByIdUseCase {

	private final StoreGateway storeGateway;

	public FindStoreByIdUseCaseImpl(StoreGateway storeGateway) {
		super();
		this.storeGateway = storeGateway;
	}

	@Override
	public Store execute(UUID id) {
		return storeGateway.findById(id);
	}

}
