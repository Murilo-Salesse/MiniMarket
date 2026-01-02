package io.github.com.salesse.MiniMarket.core.usecases.stores;

import java.util.UUID;

import io.github.com.salesse.MiniMarket.core.gateways.StoreGateway;

public class DeleteStoreUseCaseImpl implements DeleteStoreUseCase {

	private final StoreGateway storeGateway;

	public DeleteStoreUseCaseImpl(StoreGateway storeGateway) {
		super();
		this.storeGateway = storeGateway;
	}

	@Override
	public Void execute(UUID id) {
		return storeGateway.delete(id);
	}

}
