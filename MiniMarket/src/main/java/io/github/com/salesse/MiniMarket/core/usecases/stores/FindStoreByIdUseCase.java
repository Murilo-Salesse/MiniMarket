package io.github.com.salesse.MiniMarket.core.usecases.stores;

import java.util.UUID;

import io.github.com.salesse.MiniMarket.core.entities.Store;

public interface FindStoreByIdUseCase {

	Store execute(UUID id);
}
