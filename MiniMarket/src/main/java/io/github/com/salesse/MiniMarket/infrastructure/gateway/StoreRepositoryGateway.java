package io.github.com.salesse.MiniMarket.infrastructure.gateway;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import io.github.com.salesse.MiniMarket.core.entities.Store;
import io.github.com.salesse.MiniMarket.core.exceptions.NotFoundException;
import io.github.com.salesse.MiniMarket.core.gateways.StoreGateway;
import io.github.com.salesse.MiniMarket.infrastructure.mappers.StoreEntityMapper;
import io.github.com.salesse.MiniMarket.infrastructure.persistence.StoreEntity;
import io.github.com.salesse.MiniMarket.infrastructure.repositorys.StoreRepository;

@Component
public class StoreRepositoryGateway implements StoreGateway {

	private final StoreRepository storesRepository;

	public StoreRepositoryGateway(StoreRepository storesRepository) {
		super();
		this.storesRepository = storesRepository;
	}

	@Override
	public Store create(Store store) {

		return StoreEntityMapper.toDomain(storesRepository.save(StoreEntityMapper.toEntity(store)));
	}

	@Override
	public Store findById(UUID id) {

		StoreEntity foundedStore = storesRepository.findActiveById(id)
				.orElseThrow(() -> new NotFoundException("ID não encontrado"));

		return StoreEntityMapper.toDomain(foundedStore);
	}

	@Override
	public Store update(UUID id, Store store) {
		StoreEntity foundedStore = storesRepository.findActiveById(id)
				.orElseThrow(() -> new NotFoundException("ID não encontrado"));

		foundedStore.setName(store.getName());
		foundedStore.setAddress(store.getAddress());
		foundedStore.setPhone(store.getPhone());

		storesRepository.save(foundedStore);

		return StoreEntityMapper.toDomain(foundedStore);
	}

	@Override
	public List<Store> listAll() {
		return storesRepository.findAllActive().stream().map(StoreEntityMapper::toDomain).collect(Collectors.toList());
	}

	@Override
	public List<Store> findByName(String name) {

		return storesRepository.findStoresName(name).stream().map(StoreEntityMapper::toDomain)
				.collect(Collectors.toList());

	}

	@Override
	public boolean existsByCnpj(String cnpj) {
		return storesRepository.existsByCnpjAndActiveTrue(cnpj);
	}

	 @Override
	    public boolean existsById(UUID id) {
	        return storesRepository.existsById(id);
	    }

}
