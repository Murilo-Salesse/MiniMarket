package io.github.com.salesse.MiniMarket.core.usecases.stores;

import java.util.UUID;

import io.github.com.salesse.MiniMarket.core.entities.Stores;
import io.github.com.salesse.MiniMarket.core.gateways.StoreGateway;

public class DeleteStoreUseCaseImpl implements DeleteStoreUseCase {

	private final StoreGateway storeGateway;

	public DeleteStoreUseCaseImpl(StoreGateway storeGateway) {
		super();
		this.storeGateway = storeGateway;
	}

	@Override
	public Void execute(UUID id) {

		Stores store = storeGateway.findById(id);
		store.deactivate();
		storeGateway.update(id, store);

		return null;
	}

}
