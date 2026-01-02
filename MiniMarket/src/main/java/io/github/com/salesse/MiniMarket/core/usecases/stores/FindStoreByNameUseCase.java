package io.github.com.salesse.MiniMarket.core.usecases.stores;

import java.util.List;

import io.github.com.salesse.MiniMarket.core.entities.Stores;

public interface FindStoreByNameUseCase {

	List<Stores> execute(String name);
}
