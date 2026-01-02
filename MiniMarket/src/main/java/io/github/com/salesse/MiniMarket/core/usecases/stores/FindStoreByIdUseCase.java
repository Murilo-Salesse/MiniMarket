package io.github.com.salesse.MiniMarket.core.usecases.stores;

import java.util.UUID;

import io.github.com.salesse.MiniMarket.core.entities.Stores;

public interface FindStoreByIdUseCase {

	Stores execute(UUID id);
}
