package io.github.com.salesse.MiniMarket.infrastructure.beans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.github.com.salesse.MiniMarket.core.gateways.StoreGateway;
import io.github.com.salesse.MiniMarket.core.usecases.stores.CreateStoreUseCase;
import io.github.com.salesse.MiniMarket.core.usecases.stores.CreateStoreUseCaseImpl;
import io.github.com.salesse.MiniMarket.core.usecases.stores.DeleteStoreUseCase;
import io.github.com.salesse.MiniMarket.core.usecases.stores.DeleteStoreUseCaseImpl;
import io.github.com.salesse.MiniMarket.core.usecases.stores.FindStoreByIdUseCase;
import io.github.com.salesse.MiniMarket.core.usecases.stores.FindStoreByIdUseCaseImpl;
import io.github.com.salesse.MiniMarket.core.usecases.stores.ListAllStoresUseCase;
import io.github.com.salesse.MiniMarket.core.usecases.stores.ListAllStoresUseCaseImpl;
import io.github.com.salesse.MiniMarket.core.usecases.stores.UpdateStoreUseCase;
import io.github.com.salesse.MiniMarket.core.usecases.stores.UpdateStoreUseCaseImpl;

@Configuration
public class BeanConfiguration {

	@Bean
	CreateStoreUseCase createStoreUseCase(StoreGateway storeGateway) {
		return new CreateStoreUseCaseImpl(storeGateway);
	}

	@Bean
	FindStoreByIdUseCase findStoreByIdUseCase(StoreGateway storeGateway) {
		return new FindStoreByIdUseCaseImpl(storeGateway);
	}

	@Bean
	UpdateStoreUseCase updateStoreUseCase(StoreGateway storeGateway) {
		return new UpdateStoreUseCaseImpl(storeGateway);
	}

	@Bean
	ListAllStoresUseCase listAllStoresUseCase(StoreGateway storeGateway) {
		return new ListAllStoresUseCaseImpl(storeGateway);
	}

	@Bean
	DeleteStoreUseCase deleteStoreUseCase(StoreGateway storeGateway) {
		return new DeleteStoreUseCaseImpl(storeGateway);
	}
}
