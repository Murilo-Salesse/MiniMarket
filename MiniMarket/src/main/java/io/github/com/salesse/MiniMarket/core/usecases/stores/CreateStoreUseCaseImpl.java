package io.github.com.salesse.MiniMarket.core.usecases.stores;

import java.time.LocalDateTime;

import io.github.com.salesse.MiniMarket.core.entities.Stores;
import io.github.com.salesse.MiniMarket.core.exceptions.DuplicateResourceException;
import io.github.com.salesse.MiniMarket.core.gateways.StoreGateway;

public class CreateStoreUseCaseImpl implements CreateStoreUseCase {

	private final StoreGateway storeGateway;

	public CreateStoreUseCaseImpl(StoreGateway storeGateway) {
		super();
		this.storeGateway = storeGateway;
	}

	@Override
	public Stores execute(Stores store) {

		if (storeGateway.existsByCnpj(store.getCnpj())) {
			throw new DuplicateResourceException("Já existe uma loja com este CNPJ");
		}

		store.activate();
		store.setCreatedAt(LocalDateTime.now());

		return storeGateway.create(store);
	}

}
