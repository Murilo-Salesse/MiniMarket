package io.github.com.salesse.MiniMarket.infrastructure.gateway;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import io.github.com.salesse.MiniMarket.core.entities.Stores;
import io.github.com.salesse.MiniMarket.core.gateways.StoreGateway;
import io.github.com.salesse.MiniMarket.infrastructure.mappers.StoresEntityMapper;
import io.github.com.salesse.MiniMarket.infrastructure.persistence.StoresEntity;
import io.github.com.salesse.MiniMarket.infrastructure.repositorys.StoresRepository;

@Component
public class StoresRepositoryGateway implements StoreGateway {

	private final StoresRepository storesRepository;

	public StoresRepositoryGateway(StoresRepository storesRepository) {
		super();
		this.storesRepository = storesRepository;
	}

	@Override
	public Stores create(Stores store) {

		return StoresEntityMapper.toDomain(storesRepository.save(StoresEntityMapper.toEntity(store)));
	}

	@Override
	public Stores findById(UUID id) {

		StoresEntity foundedStore = storesRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("ID não encontrado"));

		return StoresEntityMapper.toDomain(foundedStore);
	}

	@Override
	public Void delete(UUID id) {
		if (!storesRepository.existsById(id)) {
			throw new RuntimeException("Loja não encontrado");
		}
		storesRepository.deleteById(id);
		return null;
	}

	@Override
	public Stores update(UUID id, Stores store) {
		StoresEntity foundedStore = storesRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("ID não encontrado"));

		foundedStore.setName(store.getName());
		foundedStore.setAddress(store.getAddress());
		foundedStore.setPhone(store.getPhone());

		storesRepository.save(foundedStore);

		return StoresEntityMapper.toDomain(foundedStore);
	}

	@Override
	public List<Stores> listAll() {
		return storesRepository.findAll().stream().map(StoresEntityMapper::toDomain).collect(Collectors.toList());
	}

}
