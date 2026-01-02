package io.github.com.salesse.MiniMarket.infrastructure.gateway;

import java.util.UUID;

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

}
