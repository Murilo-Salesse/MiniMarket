package io.github.com.salesse.MiniMarket.infrastructure.beans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.github.com.salesse.MiniMarket.core.gateways.StoreGateway;
import io.github.com.salesse.MiniMarket.core.usecases.stores.CreateStoreUseCase;
import io.github.com.salesse.MiniMarket.core.usecases.stores.CreateStoreUseCaseImpl;
import io.github.com.salesse.MiniMarket.core.usecases.stores.FindStoreByIdUseCase;
import io.github.com.salesse.MiniMarket.core.usecases.stores.FindStoreByIdUseCaseImpl;

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
}
