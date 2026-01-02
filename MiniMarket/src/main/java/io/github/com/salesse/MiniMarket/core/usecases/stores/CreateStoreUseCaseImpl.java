package io.github.com.salesse.MiniMarket.core.usecases.stores;

import io.github.com.salesse.MiniMarket.core.entities.Stores;
import io.github.com.salesse.MiniMarket.core.gateways.StoreGateway;

public class CreateStoreUseCaseImpl implements CreateStoreUseCase {

	private final StoreGateway storeGateway;

	public CreateStoreUseCaseImpl(StoreGateway storeGateway) {
		super();
		this.storeGateway = storeGateway;
	}

	@Override
	public Stores execute(Stores store) {
		return storeGateway.create(store);
	}

}
