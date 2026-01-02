package io.github.com.salesse.MiniMarket.core.usecases.stores;

import java.util.List;

import io.github.com.salesse.MiniMarket.core.entities.Stores;
import io.github.com.salesse.MiniMarket.core.gateways.StoreGateway;

public class ListAllStoresUseCaseImpl implements ListAllStoresUseCase {

	private final StoreGateway storeGateway;

	public ListAllStoresUseCaseImpl(StoreGateway storeGateway) {
		super();
		this.storeGateway = storeGateway;
	}

	@Override
	public List<Stores> listAll() {
		return storeGateway.listAll();
	}

}
