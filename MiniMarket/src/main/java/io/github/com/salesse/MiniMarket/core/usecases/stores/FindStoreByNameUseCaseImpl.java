package io.github.com.salesse.MiniMarket.core.usecases.stores;

import java.util.List;

import io.github.com.salesse.MiniMarket.core.entities.Stores;
import io.github.com.salesse.MiniMarket.core.gateways.StoreGateway;

public class FindStoreByNameUseCaseImpl implements FindStoreByNameUseCase{
	
	private final StoreGateway storeGateway;

	public FindStoreByNameUseCaseImpl(StoreGateway storeGateway) {
		super();
		this.storeGateway = storeGateway;
	}

	@Override
	public List<Stores> execute(String name) {
		return storeGateway.findByName(name);
	}

}
