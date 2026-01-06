package io.github.com.salesse.MiniMarket.core.usecases.users;

import io.github.com.salesse.MiniMarket.core.entities.User;
import io.github.com.salesse.MiniMarket.core.gateways.UserGateway;

public class CreateUserUseCaseImpl implements CreateUserUseCase {

	private final UserGateway userGateway;

	public CreateUserUseCaseImpl(UserGateway userGateway) {
		super();
		this.userGateway = userGateway;
	}

	@Override
	public User execute(User user) {
		return userGateway.create(user);
	}

}
