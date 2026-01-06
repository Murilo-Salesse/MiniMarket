package io.github.com.salesse.MiniMarket.core.gateways;

import java.util.List;
import java.util.UUID;

import io.github.com.salesse.MiniMarket.core.entities.Store;

public interface StoreGateway {

	Store create(Store store);
	Store findById(UUID id);
	Store update(UUID id, Store store);
	List<Store> listAll();
	List<Store> findByName(String name);
	boolean existsByCnpj(String cnpj);
}
