package io.github.com.salesse.MiniMarket.infrastructure.beans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import io.github.com.salesse.MiniMarket.core.gateways.CategoryGateway;
import io.github.com.salesse.MiniMarket.core.gateways.LoginGateway;
import io.github.com.salesse.MiniMarket.core.gateways.RoleGateway;
import io.github.com.salesse.MiniMarket.core.gateways.StoreGateway;
import io.github.com.salesse.MiniMarket.core.gateways.TokenGateway;
import io.github.com.salesse.MiniMarket.core.gateways.UserGateway;
import io.github.com.salesse.MiniMarket.core.usecases.categories.CreateCategoryUseCase;
import io.github.com.salesse.MiniMarket.core.usecases.categories.CreateCategoryUseCaseImpl;
import io.github.com.salesse.MiniMarket.core.usecases.categories.DeleteCategorieByIdUseCase;
import io.github.com.salesse.MiniMarket.core.usecases.categories.DeleteCategorieByIdUseCaseImpl;
import io.github.com.salesse.MiniMarket.core.usecases.categories.FindCategoryByDescUseCase;
import io.github.com.salesse.MiniMarket.core.usecases.categories.FindCategoryByDescUseCaseImpl;
import io.github.com.salesse.MiniMarket.core.usecases.categories.FindCategoryByIdUseCase;
import io.github.com.salesse.MiniMarket.core.usecases.categories.FindCategoryByIdUseCaseImpl;
import io.github.com.salesse.MiniMarket.core.usecases.categories.ListAllCategoriesUseCase;
import io.github.com.salesse.MiniMarket.core.usecases.categories.ListAllCategoriesUseCaseImpl;
import io.github.com.salesse.MiniMarket.core.usecases.categories.UpdateCategorieUseCase;
import io.github.com.salesse.MiniMarket.core.usecases.categories.UpdateCategorieUseCaseImpl;
import io.github.com.salesse.MiniMarket.core.usecases.login.LoginUserUseCase;
import io.github.com.salesse.MiniMarket.core.usecases.login.LoginUserUseCaseImpl;
import io.github.com.salesse.MiniMarket.core.usecases.stores.CreateStoreUseCase;
import io.github.com.salesse.MiniMarket.core.usecases.stores.CreateStoreUseCaseImpl;
import io.github.com.salesse.MiniMarket.core.usecases.stores.DeleteStoreUseCase;
import io.github.com.salesse.MiniMarket.core.usecases.stores.DeleteStoreUseCaseImpl;
import io.github.com.salesse.MiniMarket.core.usecases.stores.FindStoreByIdUseCase;
import io.github.com.salesse.MiniMarket.core.usecases.stores.FindStoreByIdUseCaseImpl;
import io.github.com.salesse.MiniMarket.core.usecases.stores.FindStoreByNameUseCase;
import io.github.com.salesse.MiniMarket.core.usecases.stores.FindStoreByNameUseCaseImpl;
import io.github.com.salesse.MiniMarket.core.usecases.stores.ListAllStoresUseCase;
import io.github.com.salesse.MiniMarket.core.usecases.stores.ListAllStoresUseCaseImpl;
import io.github.com.salesse.MiniMarket.core.usecases.stores.UpdateStoreUseCase;
import io.github.com.salesse.MiniMarket.core.usecases.stores.UpdateStoreUseCaseImpl;
import io.github.com.salesse.MiniMarket.core.usecases.users.CreateUserUseCase;
import io.github.com.salesse.MiniMarket.core.usecases.users.CreateUserUseCaseImpl;
import io.github.com.salesse.MiniMarket.core.usecases.users.DeleteUserByIdUseCase;
import io.github.com.salesse.MiniMarket.core.usecases.users.DeleteUserByIdUseCaseImpl;
import io.github.com.salesse.MiniMarket.core.usecases.users.FindUserByEmailUseCase;
import io.github.com.salesse.MiniMarket.core.usecases.users.FindUserByEmailUseCaseImpl;
import io.github.com.salesse.MiniMarket.core.usecases.users.FindUserByIdUseCase;
import io.github.com.salesse.MiniMarket.core.usecases.users.FindUserByIdUseCaseImpl;
import io.github.com.salesse.MiniMarket.core.usecases.users.FindUserByNameUseCase;
import io.github.com.salesse.MiniMarket.core.usecases.users.FindUserByNameUseCaseImpl;
import io.github.com.salesse.MiniMarket.core.usecases.users.ListAllUsersUseCase;
import io.github.com.salesse.MiniMarket.core.usecases.users.ListAllUsersUseCaseImpl;
import io.github.com.salesse.MiniMarket.core.usecases.users.UpdateUserUseCase;
import io.github.com.salesse.MiniMarket.core.usecases.users.UpdateUserUseCaseImpl;

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
	FindStoreByNameUseCase findStoreByNameUseCase(StoreGateway storeGateway) {
		return new FindStoreByNameUseCaseImpl(storeGateway);
	}

	@Bean
	DeleteStoreUseCase deleteStoreUseCase(StoreGateway storeGateway) {
		return new DeleteStoreUseCaseImpl(storeGateway);
	}

	@Bean
	CreateUserUseCase createUserUseCase(UserGateway userGateway, PasswordEncoder passwordEncoder,
			RoleGateway roleGateway) {
		return new CreateUserUseCaseImpl(userGateway, passwordEncoder, roleGateway);
	}

	@Bean
	FindUserByIdUseCase findUserByIdUseCase(UserGateway userGateway) {
		return new FindUserByIdUseCaseImpl(userGateway);
	}

	@Bean
	FindUserByNameUseCase findUserByNameUseCase(UserGateway userGateway) {
		return new FindUserByNameUseCaseImpl(userGateway);
	}

	@Bean
	FindUserByEmailUseCase findUserByEmailUseCase(UserGateway userGateway) {
		return new FindUserByEmailUseCaseImpl(userGateway);
	}

	@Bean
	ListAllUsersUseCase listAllUsersUseCase(UserGateway userGateway) {
		return new ListAllUsersUseCaseImpl(userGateway);
	}

	@Bean
	UpdateUserUseCase updateUserUseCase(UserGateway userGateway) {
		return new UpdateUserUseCaseImpl(userGateway);
	}

	@Bean
	DeleteUserByIdUseCase deleteUserByIdUseCase(UserGateway userGateway) {
		return new DeleteUserByIdUseCaseImpl(userGateway);
	}

	@Bean
	LoginUserUseCase loginUserUseCase(LoginGateway loginGateway, PasswordEncoder passwordEncoder,
			TokenGateway tokenGateway) {
		return new LoginUserUseCaseImpl(loginGateway, passwordEncoder, tokenGateway);
	}

	@Bean
	CreateCategoryUseCase createCategoryUseCase(CategoryGateway categoryGateway, StoreGateway storeGateway) {
		return new CreateCategoryUseCaseImpl(categoryGateway, storeGateway);
	}

	@Bean
	FindCategoryByIdUseCase findCategoryByIdUseCase(CategoryGateway categoryGateway) {
		return new FindCategoryByIdUseCaseImpl(categoryGateway);

	}

	@Bean
	ListAllCategoriesUseCase listAllCategoriesUseCase(CategoryGateway categoryGateway) {
		return new ListAllCategoriesUseCaseImpl(categoryGateway);

	}

	@Bean
	FindCategoryByDescUseCase findCategoryByDescUseCase(CategoryGateway categoryGateway) {
		return new FindCategoryByDescUseCaseImpl(categoryGateway);

	}

	@Bean
	UpdateCategorieUseCase updateCategorieUseCase(CategoryGateway categoryGateway) {
		return new UpdateCategorieUseCaseImpl(categoryGateway);

	}

	@Bean
	DeleteCategorieByIdUseCase deleteCategorieByIdUseCase(CategoryGateway categoryGateway) {
		return new DeleteCategorieByIdUseCaseImpl(categoryGateway);

	}
}
