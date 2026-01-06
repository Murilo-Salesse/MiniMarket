package io.github.com.salesse.MiniMarket.core.usecases.stores;

import java.time.LocalDateTime;

import io.github.com.salesse.MiniMarket.core.entities.Store;
import io.github.com.salesse.MiniMarket.core.exceptions.DuplicateResourceException;
import io.github.com.salesse.MiniMarket.core.gateways.StoreGateway;

public class CreateStoreUseCaseImpl implements CreateStoreUseCase {

	private final StoreGateway storeGateway;

	public CreateStoreUseCaseImpl(StoreGateway storeGateway) {
		super();
		this.storeGateway = storeGateway;
	}

	@Override
	public Store execute(Store store) {

		if (storeGateway.existsByCnpj(store.getCnpj())) {
			throw new DuplicateResourceException("Já existe uma loja com este CNPJ");
		}

		store.setCreatedAt(LocalDateTime.now());

		return storeGateway.create(store);
	}

}
