package io.github.com.salesse.MiniMarket.core.usecases.users;

import java.util.UUID;

import io.github.com.salesse.MiniMarket.core.entities.User;
import io.github.com.salesse.MiniMarket.core.gateways.UserGateway;

public class FindUserByIdUseCaseImpl implements FindUserByIdUseCase {

	private final UserGateway userGateway;

	public FindUserByIdUseCaseImpl(UserGateway userGateway) {
		super();
		this.userGateway = userGateway;
	}

	@Override
	public User execute(UUID id) {

		return userGateway.findById(id);
	}

}
