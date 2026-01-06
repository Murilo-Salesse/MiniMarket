package io.github.com.salesse.MiniMarket.core.usecases.stores;

import java.util.List;

import io.github.com.salesse.MiniMarket.core.entities.Store;

public interface ListAllStoresUseCase {

	List<Store> execute();
}
