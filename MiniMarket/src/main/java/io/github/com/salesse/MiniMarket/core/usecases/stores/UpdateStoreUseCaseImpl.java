package io.github.com.salesse.MiniMarket.core.usecases.stores;

import java.util.UUID;

import io.github.com.salesse.MiniMarket.core.entities.Store;
import io.github.com.salesse.MiniMarket.core.exceptions.NotFoundException;
import io.github.com.salesse.MiniMarket.core.gateways.StoreGateway;

public class UpdateStoreUseCaseImpl implements UpdateStoreUseCase {

	private final StoreGateway storeGateway;

	public UpdateStoreUseCaseImpl(StoreGateway storeGateway) {
		super();
		this.storeGateway = storeGateway;
	}

	@Override
	public Store execute(UUID id, Store store) {

		Store existingStore = storeGateway.findById(id);

		if (existingStore == null) {
			throw new NotFoundException("Loja não encontrada");
		}

		existingStore.setName(store.getName());
		existingStore.setAddress(store.getAddress());
		existingStore.setPhone(store.getPhone());
		existingStore.setActive(store.isActive());

		return storeGateway.update(id, existingStore);
	}

}
