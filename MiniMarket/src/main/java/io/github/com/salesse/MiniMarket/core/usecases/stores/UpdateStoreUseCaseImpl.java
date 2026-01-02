package io.github.com.salesse.MiniMarket.core.usecases.stores;

import java.util.UUID;

import io.github.com.salesse.MiniMarket.core.entities.Stores;
import io.github.com.salesse.MiniMarket.core.gateways.StoreGateway;

public class UpdateStoreUseCaseImpl implements UpdateStoreUseCase {

	private final StoreGateway storeGateway;

	public UpdateStoreUseCaseImpl(StoreGateway storeGateway) {
		super();
		this.storeGateway = storeGateway;
	}

	@Override
	public Stores execute(UUID id, Stores store) {
		return storeGateway.update(id, store);
	}

}
