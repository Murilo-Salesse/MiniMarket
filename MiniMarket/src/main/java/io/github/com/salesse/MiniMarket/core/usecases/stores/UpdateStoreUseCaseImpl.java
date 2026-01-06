package io.github.com.salesse.MiniMarket.core.usecases.stores;

import java.util.UUID;

import io.github.com.salesse.MiniMarket.core.entities.Stores;
import io.github.com.salesse.MiniMarket.core.exceptions.NotFoundException;
import io.github.com.salesse.MiniMarket.core.gateways.StoreGateway;

public class UpdateStoreUseCaseImpl implements UpdateStoreUseCase {

	private final StoreGateway storeGateway;

	public UpdateStoreUseCaseImpl(StoreGateway storeGateway) {
		super();
		this.storeGateway = storeGateway;
	}

	@Override
	public Stores execute(UUID id, Stores store) {

		Stores existingStore = storeGateway.findById(id);

		if (existingStore == null) {
			throw new NotFoundException("Loja não encontrada");
		}

		/* Update just allowed methods */
		existingStore.setName(store.getName());
		existingStore.setAddress(store.getAddress());
		existingStore.setPhone(store.getPhone());
		existingStore.setActive(store.isActive());

		return storeGateway.update(id, existingStore);
	}

}
