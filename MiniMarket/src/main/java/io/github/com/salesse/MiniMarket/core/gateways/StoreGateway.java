package io.github.com.salesse.MiniMarket.core.gateways;

import java.util.List;
import java.util.UUID;

import io.github.com.salesse.MiniMarket.core.entities.Stores;

public interface StoreGateway {

	Stores create(Stores store);
	Stores findById(UUID id);
	Stores update(UUID id, Stores store);
	List<Stores> listAll();
	Void delete(UUID id);
}
